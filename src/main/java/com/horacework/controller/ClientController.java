package com.horacework.controller;


import com.horacework.model.MarkeridEntity;
import com.horacework.model.MarkerinfoEntity;
import com.horacework.model.UserEntity;
import com.horacework.repository.MarkeridRepository;
import com.horacework.repository.MarkerinfoRepository;
import com.horacework.repository.UserRepository;
import com.horacework.utils.JsonUtil;
import com.horacework.utils.MyPrivateKey;
import com.horacework.utils.RSAUtils;
import com.horacework.utils.SuccessStateObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController extends BaseController {

    @Autowired
    private UserRepository mUserRepo;
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
    public void userlogin() throws Exception {
        String resultStr = "";
        //接受已加密的字符串data，并解密。
        //String privateKey = MyPrivateKey.getPrivateKey();
        String username = "chen";
        String password = "aaaa";
//        byte[] encodedData = data.getBytes();
//        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
//        String realData = new String(decodedData);
//        username = realData.split(",")[0];
//        password = realData.split(",")[1];
        if (username.equals("") || password.equals("") ){
            //username与password不能为空
//            response.getWriter().write("");
            resultStr=JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"参数不能为空"));

        }else {
            UserEntity result = mUserRepo.findUserSerect(username);
            try {
                if (password.equals(result.getPassword())){
                    result.setPassword("隐藏密码");
                    resultStr=JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"查询成功",result));
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                resultStr=JsonUtil.toJson(new SuccessStateObj(404,System.currentTimeMillis(),0,0,"无此用户"));
            }
        }
        response.getWriter().write(resultStr);
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
