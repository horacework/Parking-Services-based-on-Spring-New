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

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public void getuser(){
        List<UserEntity> results=mUserRepo.findAll();
        String restStr;

        restStr=results==null?"{}": JsonUtil.toJson(results);

        try {
            response.getWriter().write(restStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/userSignin",method = RequestMethod.GET)
    public void userSignin(@RequestParam String name , @RequestParam String pass , @RequestParam String pass2){

    }
    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public void userlogin(@RequestParam String data) throws Exception {
        String resultStr;
        //接受已加密的字符串data，并解密。
        String privateKey = MyPrivateKey.getPrivateKey();
//        String username = "chen";     //测试数据
//        String password = "aaaa";     //测试数据
//        String deviceId = "ssssssssssssssssssssssssssssssssssss";     //测试数据
        String username;
        String password;
        String deviceId;
        byte[] encodedData = data.getBytes();
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
        String realData = new String(decodedData);
        username = realData.split(",")[0];
        password = realData.split(",")[1];//TODO:安卓设备中应该检测用户名与密码内不能存在逗号
        deviceId = realData.split(",")[3];//TODO:获得安卓设备识别码 TelephonyManager.getDeviceId()
        if (username.equals("") || password.equals("") || deviceId.equals("") ){
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
                    userlog.setDeviceId(deviceId);
                    userlog.setIsLoginOut(0);
//                    Date now = new Date();
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    userlog.setLoginTime(new Timestamp(System.currentTimeMillis()));
                    UserlogEntity logResult = mUserlogRepo.saveAndFlush(userlog);

                }else {
                    resultStr=JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"用户名或密码错误"));
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                resultStr=JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"查无此用户"));
            }
        }
        response.getWriter().write(resultStr);//返回已组装好的JSON
    }
    @RequestMapping(value = "/getAllMarkerId",method = RequestMethod.GET)
    public void getAllMarkerId() {
        //List<UserEntity> results=mUserRepo.findAll();
        List<MarkeridEntity> results = markeridRepo.findAll();
        String resStr;
        if (results == null) {
            resStr = "{}";
        } else {
            resStr = JsonUtil.toJson(results);
        }
        try {
            response.getWriter().write(resStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/getMarkerInfoById",method = RequestMethod.GET)
    public void getMarkerInfoById (@RequestParam String id) {

        MarkerinfoEntity result = markerinfoRepo.findOne(id);
        String string;
        if (result == null) {
            string = "{}";
        } else {
            string = JsonUtil.toJson(result);
        }
        try {
            response.getWriter().write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
