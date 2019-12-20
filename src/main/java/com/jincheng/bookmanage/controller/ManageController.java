package com.jincheng.bookmanage.controller;

import com.jincheng.bookmanage.entity.Manage;
import com.jincheng.bookmanage.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService service;

    @RequestMapping("/toFrame")
    public String toFrame(String name, String password, String role, Model model){
        //后台登录
        boolean temp=false;
        temp=service.findManagerIfTrue(name,password,role,model);
        if (temp){
            return "backstage/frame";
        }else{
            return "backstage/login1";
        }
    }

}
