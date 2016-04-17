package com.horacework.controller;

import com.horacework.model.MarkerinfoEntity;
import com.horacework.model.UserEntity;
import com.horacework.repository.MarkerinfoRepository;
import com.horacework.repository.UserRepository;
import com.horacework.utils.JsonUtil;
import com.mysql.jdbc.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
public class MainController extends BaseController {

    @Autowired
    private UserRepository mUserRepo;
    @Autowired
    private MarkerinfoRepository markerinfoRepo;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public void getuser(){
        List<UserEntity> results=mUserRepo.findAll();
        String restStr;

        restStr=results==null?"没有任何数据": JsonUtil.toJson(results);

        try {
            response.getWriter().write(restStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/getAllMarkerId",method = RequestMethod.GET)
    public void getAllMarkerId(){
        //List<UserEntity> results=mUserRepo.findAll();
        List<MarkerinfoEntity> results = markerinfoRepo.findAll();
        String resStr;
        if (results == null){
            resStr = "{}";
        }else {
            resStr = JsonUtil.toJson(results);
        }
        try {
            response.getWriter().write(resStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}