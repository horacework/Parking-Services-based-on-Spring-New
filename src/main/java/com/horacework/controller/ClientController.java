package com.horacework.controller;


import com.horacework.model.*;
import com.horacework.repository.*;
import com.horacework.utils.JsonUtil;
import com.horacework.utils.MyPrivateKey;
import com.horacework.utils.RSAUtils;
import com.horacework.utils.SuccessStateObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.swing.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/client")
public class ClientController extends BaseController {

    @Autowired
    private UserRepository mUserRepo;
    @Autowired
    private UserlogRepository mUserlogRepo;
    @Autowired
    private UsermoneyRepository mUsermoneyRepository;
    @Autowired
    private MarkeridRepository markeridRepo;
    @Autowired
    private MarkerinfoRepository markerinfoRepo;

    private String privateKey = MyPrivateKey.getPrivateKey();

    //用户数据操作

    //用户的注册与登入登出API
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)//仅供测试
    public void getUser(){
        List<UserEntity> results=mUserRepo.findAll();
        String restStr;

        restStr=results==null?"{}": JsonUtil.toJson(results);

        try {
            response.getWriter().write(restStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/userSignup",method = RequestMethod.POST)
    public void userSignup(@RequestParam String username , @RequestParam String password , @RequestParam String password2 , @RequestParam String deviceid) throws Exception {
        String resultStr;

        if (!password.equals(password2)){
            //两次密码不一致的情况
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"两次密码不一致"));
        }else if(username.equals("") || password.equals("") || deviceid.equals("") ){
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"参数不能为空"));
        }else if (mUserRepo.userExist(username) != null){
            //查询username是否被占用
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"该username已被占用"));
        }else {
            UserEntity newUser = new UserEntity();
            newUser.setId(UUID.randomUUID().toString());
            newUser.setName(username);
            newUser.setPassword(password);
            UserEntity userEntity = mUserRepo.saveAndFlush(newUser);
            userEntity.setPassword("****");
            resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"注册成功",userEntity));
            //注册成功后自动给账户充值10块钱
            UsermoneyEntity usermoneyChange = new UsermoneyEntity();
            usermoneyChange.setUserId(userEntity.getId());
            usermoneyChange.setCurrentTime(new Timestamp(System.currentTimeMillis()));
            usermoneyChange.setType(2);
            usermoneyChange.setFigure(10);
            usermoneyChange.setRemain(10);
            UsermoneyEntity usermoneyResult = mUsermoneyRepository.saveAndFlush(usermoneyChange);
            //注册成功后自动登录，记录插入
            UserlogEntity userlog = new UserlogEntity();
            userlog.setUserId(userEntity.getId());
            userlog.setDeviceId(deviceid);
            userlog.setIsLoginOut(0);
            userlog.setLoginTime(new Timestamp(System.currentTimeMillis()));
            UserlogEntity logResult = mUserlogRepo.saveAndFlush(userlog);
        }
        response.getWriter().write(resultStr);
    }
    @RequestMapping(value = "/usernameCheck",method = RequestMethod.GET)//分离出来待使用，注册功能已包括
    public void usernameChack(@RequestParam String data) throws Exception {
        String resultStr;
        String username = RSAUtils.DecodeDataToString(data,privateKey);
        //String username = "che";//测试数据
        UserEntity usernameExist = mUserRepo.userExist(username);
        if (usernameExist != null){
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"该username已被占用"));
        }else {
            resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"该username可以被注册"));
        }
        response.getWriter().write(resultStr);
    }
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public void userLogin(@RequestParam String username ,@RequestParam String password , @RequestParam String deviceid) throws Exception {
        String resultStr;

        if (username.equals("") || password.equals("") || deviceid.equals("") ){
            //username与password不能为空
            resultStr=JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"参数不能为空"));
        }else {
            UserEntity result = mUserRepo.findUserSerect(username);
            try {
                if (password.equals(result.getPassword())){
                    result.setPassword("****");//隐藏密码数据返回JSON
                    resultStr=JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"登录成功",result));
                    //插入userlog日志数据表
                    UserlogEntity userlog = new UserlogEntity();
                    userlog.setUserId(result.getId());
                    userlog.setDeviceId(deviceid);
                    userlog.setIsLoginOut(0);
//                    Date now = new Date();
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    userlog.setLoginTime(new Timestamp(System.currentTimeMillis()));
                    UserlogEntity logResult = mUserlogRepo.saveAndFlush(userlog);

                }else {
                    resultStr=JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"用户名或密码错误"));
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                resultStr=JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"查无此用户"));
            }
        }
        response.getWriter().write(resultStr);//返回已组装好的JSON
    }
    @RequestMapping(value = "/userLogout",method = RequestMethod.POST)
    public void userLogout(@RequestParam String userid , @RequestParam String deviceid) throws Exception{
        String resultStr;
        try {
            UserlogEntity userlogEntity = mUserlogRepo.findUserLogout(userid ,deviceid);
            userlogEntity.setLogoutTime(new Timestamp(System.currentTimeMillis()));
            userlogEntity.setIsLoginOut(1);
            UserlogEntity userLogoutResult = mUserlogRepo.saveAndFlush(userlogEntity);
            resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"登出成功"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"数据发生错误"));
        }
        response.getWriter().write(resultStr);
    }

    //用户的服务API

    //用户余额操作
    @RequestMapping(value = "/userCheckMyMoney",method = RequestMethod.GET)
    public void userCheckMyMoney(@RequestParam String userid) throws Exception {
        //获取用户余额
        String resultStr;
        try {
            UsermoneyEntity usermoneyEntity = mUsermoneyRepository.findUserMoneyLastLogById(userid);
            resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"查询成功",usermoneyEntity));
        } catch (NullPointerException e) {
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"查询失败"));
        }
        response.getWriter().write(resultStr);
    }
    @RequestMapping(value = "/userMyMoneyLog",method = RequestMethod.GET)
    public void userMyMoneyLog(@RequestParam String userid) throws Exception {
        //获取用户余额的支出记录
        String resultStr;
        try {
            List<UsermoneyEntity> usermoneyEntityList = mUsermoneyRepository.findUserMoneyAllLogById(userid);
            resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"登出成功",usermoneyEntityList));
        }catch (NullPointerException e){
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"查询记录失败"));
        }
        response.getWriter().write(resultStr);
    }
    public String changeUserMoney(String userid , int type , int figure) throws Exception {
        //改变用户余额
        //Type变量约定：1为支出，2为充值
        String resultStr;
        int moneyRemain;
        try {
            UsermoneyEntity usermoneyEntity = mUsermoneyRepository.findUserMoneyLastLogById(userid);
            UsermoneyEntity usermoneyChange = new UsermoneyEntity();
            UsermoneyEntity usermoneyResult;
            moneyRemain = usermoneyEntity.getRemain();
            switch (type){
                case 1:
                    if (moneyRemain < figure){
                        //余额不足
                        resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"余额不足"));
                    }else {
                        moneyRemain = moneyRemain - figure;
                        usermoneyChange.setUserId(userid);
                        usermoneyChange.setCurrentTime(new Timestamp(System.currentTimeMillis()));
                        usermoneyChange.setType(type);
                        usermoneyChange.setFigure(figure);
                        usermoneyChange.setRemain(moneyRemain);
                        usermoneyResult = mUsermoneyRepository.saveAndFlush(usermoneyChange);
                        resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"交易成功",usermoneyResult));
                    }
                    break;
                case 2:
                    moneyRemain = moneyRemain + figure;
                    usermoneyChange.setUserId(userid);
                    usermoneyChange.setCurrentTime(new Timestamp(System.currentTimeMillis()));
                    usermoneyChange.setType(type);
                    usermoneyChange.setFigure(figure);
                    usermoneyChange.setRemain(moneyRemain);
                    usermoneyResult = mUsermoneyRepository.saveAndFlush(usermoneyChange);
                    resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"充值成功",usermoneyResult));
                    break;
                default:
                    resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"类型码错误"));
            }
        } catch (NullPointerException e) {
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"查询失败"));
        }
        return resultStr;
    }

    //地图中Marker数据
    @RequestMapping(value = "/getAllMarkerId",method = RequestMethod.GET)
    public void getAllMarkerId() throws Exception {
        //List<UserEntity> results=mUserRepo.findAll();
        List<MarkeridEntity> results = markeridRepo.findAll();
        String resStr;
        if (results == null) {
            resStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"数据发生错误"));
        } else {
            resStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"数据查询成功",results));
        }
        try {
            response.getWriter().write(resStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/getMarkerInfoById",method = RequestMethod.GET)
    public void getMarkerInfoById (@RequestParam String id) throws Exception {

        MarkerinfoEntity result = markerinfoRepo.findOne(id);
        String string;
        if (result == null) {
            string = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"数据发生错误","{}"));
        } else {
            string = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"数据查找成功",result));
        }
        try {
            response.getWriter().write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
