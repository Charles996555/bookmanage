package com.jincheng.bookmanage.controller;

import com.jincheng.bookmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserFrontController {

    @Autowired
    UserService service;

    @RequestMapping("/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession session){
        map.put("msg","用户名或者密码错误");
        Boolean isAccess=service.userIsExist(username,password);
        if (isAccess==true){
            session.setAttribute("loginUser",username);
            return "redirect:/toftIndex";
        }
        return "/front/login";
    }


}

