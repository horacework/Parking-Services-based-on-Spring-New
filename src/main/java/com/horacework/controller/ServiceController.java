package com.horacework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("service")
public class ServiceController extends BaseController {



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }



}