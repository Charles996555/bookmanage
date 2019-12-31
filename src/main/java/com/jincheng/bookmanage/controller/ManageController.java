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

    private static final String SUCCESS_CHANGEPASS="成功";
    @Autowired
    ManageService service;

    @RequestMapping("/toFrame")
    public String toFrame(String name, String password, String role, Model model){
        //后台登录
        boolean temp=false;
        temp=service.findManagerIfTrue(name,password,role,model);
        if (temp){
            model.addAttribute("managename",name);
            return "backstage/frame";
        }else{
            return "backstage/login1";
        }
    }

    /**
     * 去修改密码界面
     */
    @RequestMapping("/toModify_password")
    public String toModify_password(String managename,Model model){
        model.addAttribute("manager",service.findManagerByManagename(managename));
        return "backstage/tgls/modify_password";
    }

    /**
     * 去查看信息界面
     */
    @RequestMapping("/toModify_message")
    public String toModify_message(String managename,Model model){
        Manage manager=service.findManagerByManagename(managename);
        model.addAttribute("manager",manager);
        return "backstage/tgls/modify_message";
    }

    /**
     * 修改密码
     */
    @RequestMapping("/changePassword")
    public String changePassword(String managename,String oldpassword,String password,String password2,Model model){
        String temp=service.changePassword(managename,oldpassword,password,password2);
        if(temp.contains(SUCCESS_CHANGEPASS)){
            Manage manager=service.findManagerByManagename(managename);
            model.addAttribute("manager",manager);
            model.addAttribute("msg2",temp);
            return "/backstage/tgls/modify_password";
        }
        Manage manager=service.findManagerByManagename(managename);
        model.addAttribute("manager",manager);
        model.addAttribute("msg2",temp);
        return "/backstage/tgls/modify_password";

    }

}
