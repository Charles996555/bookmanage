package com.jincheng.bookmanage.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface CartService {
    void addShopCart(String name, String img, Double price, Integer count, HttpSession session);
    String showCartList(Model model,HttpSession session);
    Double showTotalPrice(HttpSession session);

}
