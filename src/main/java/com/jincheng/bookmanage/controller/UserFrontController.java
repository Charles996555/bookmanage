package com.jincheng.bookmanage.controller;

import com.jincheng.bookmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserFrontController {

    public static final String SUCCESS_REGISTER="成功";
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
        return "front/login";
    }

    @RequestMapping("/register")
    public String register(String username, String password, Model model){
        String msg=service.register(username,password);
        model.addAttribute("msg",msg);
        if (msg.contains(SUCCESS_REGISTER)){
            return "redirect:/login";
        }
        return "front/register";
    }


}

