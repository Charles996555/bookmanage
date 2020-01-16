package com.jincheng.bookmanage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jincheng.bookmanage.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;


@Controller
public class CartController {

    @Autowired
    CartService service;

    @RequestMapping("/toCart")
    public String toCart(Model model,HttpSession session){

        //展示购物车数据
        String str=service.showCartList(model,session);

        return "front/cart";
    }

    @RequestMapping("/toShopCar")
    @ResponseBody
    public String toShopCar(String name, String img, Double price, Integer count,HttpSession session) throws JsonProcessingException {
        service.addShopCart(name,img,price,count,session);
        //这里要把字符串转换成json数据
        return new ObjectMapper().writeValueAsString("添加购物车成功......");
//        return "添加购物车成功......";
    }

    @RequestMapping("/showTotalPrice")
    @ResponseBody
    public String showTotalPrice(HttpSession session) throws JsonProcessingException {
        //展示总价格！！！
        double total=service.showTotalPrice(session);
        DecimalFormat df = new DecimalFormat("#.00");
        total=Double.parseDouble(df.format(total));
        String show=total+"";
        return show;

    }


}
