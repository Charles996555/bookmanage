package com.jincheng.bookmanage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jincheng.bookmanage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    OrderService service;

    @RequestMapping("/saveAddMessage")
    @ResponseBody
    public String saveAddMessage(Double totalPrice, HttpSession session) throws JsonProcessingException {
        service.saveAddMessage(totalPrice,session);
        return new ObjectMapper().writeValueAsString("订单生成成功......请支付......");
    }
}
