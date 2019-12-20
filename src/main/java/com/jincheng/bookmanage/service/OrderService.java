package com.jincheng.bookmanage.service;

import javax.servlet.http.HttpSession;

public interface OrderService {
    void saveAddMessage(Double totalPrice, HttpSession session);
}
