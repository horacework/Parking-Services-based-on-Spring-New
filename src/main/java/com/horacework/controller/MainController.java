package com.horacework.controller;

import com.horacework.utils.MyPrivateKey;
import com.horacework.utils.RSAUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController extends BaseController {



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/rsa",method = RequestMethod.GET)
    public void RSAGenerateTest() throws Exception {
        String publicKey = null;
        String privateKey = null;
//        try {
//            Map<String, Object> keyMap = RSAUtils.genKeyPair();
//            publicKey = RSAUtils.getPublicKey(keyMap);
//            privateKey = RSAUtils.getPrivateKey(keyMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        publicKey = MyPrivateKey.getPublicKey();
        privateKey = MyPrivateKey.getPrivateKey();
        //模拟加密前用户名与密码
        String source = ",123456789";
        byte[] data = source.getBytes();
        //加密后的文字
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        //加密之后再解密
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
        String target = new String(decodedData);
        String[] username = target.split(",");
        //String publicKeyAndpri = publicKey + "," + privateKey;
        if (username[0].equals("")){
            response.getWriter().write("真的是null");
        }else {
            response.getWriter().write(username[0]);
        }


    }


}