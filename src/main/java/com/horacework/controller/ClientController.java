package com.horacework.controller;


import com.horacework.model.MarkeridEntity;
import com.horacework.model.MarkerinfoEntity;
import com.horacework.model.UserEntity;
import com.horacework.model.UserlogEntity;
import com.horacework.repository.MarkeridRepository;
import com.horacework.repository.MarkerinfoRepository;
import com.horacework.repository.UserRepository;
import com.horacework.repository.UserlogRepository;
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
    private MarkeridRepository markeridRepo;
    @Autowired
    private MarkerinfoRepository markerinfoRepo;

    private String privateKey = MyPrivateKey.getPrivateKey();

    //用户数据操作
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
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
//        String realData = RSAUtils.DecodeDataToString(data,privateKey);
//        String username = realData.split(",")[0];
//        String password = realData.split(",")[1];
//        String password2 = realData.split(",")[2];
//        String deviceId = realData.split(",")[3];

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
    @RequestMapping(value = "/usernameCheck",method = RequestMethod.GET)
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
        //接受已加密的字符串data，并解密。
//        String username = "chen";     //测试数据
//        String password = "aaaa";     //测试数据
//        String deviceId = "ssssssssssssssssssssssssssssssssssss";     //测试数据
//        String username;
//        String password;
//        String deviceId;
//        byte[] encodedData = data.getBytes();
//        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
//        String realData = new String(decodedData);
//        username = realData.split(",")[0];
//        password = realData.split(",")[1];//TODO:安卓设备中应该检测用户名与密码内不能存在逗号
//        deviceId = realData.split(",")[2];//TODO:获得安卓设备识别码 TelephonyManager.getDeviceId()
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
    @RequestMapping(value = "/userLogout",method = RequestMethod.GET)
    public void userLogout(@RequestParam String data) throws Exception{
        String resultStr;
        String realData = RSAUtils.DecodeDataToString(data,privateKey);
        String uid = realData.split(",")[0];
        //String deviceId = realData.split(",")[1];
        try {
            UserlogEntity userlogEntity = mUserlogRepo.updateUserLogout(uid,new Timestamp(System.currentTimeMillis()));
            resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"登出成功"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            resultStr = JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"数据发生错误"));
        }
        response.getWriter().write(resultStr);
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
