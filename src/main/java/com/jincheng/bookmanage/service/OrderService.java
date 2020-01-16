package com.jincheng.bookmanage.service;

import com.github.pagehelper.PageInfo;
import com.jincheng.bookmanage.entity.Order;

import javax.servlet.http.HttpSession;

public interface OrderService {
    void saveAddMessage(Double totalPrice, HttpSession session);


    PageInfo<Order> getOrderList(int pageNo, int pageSize);

    String deleteOrder(Integer id);

    Double getOrderTotalPrice();

    Double getPayOrderPrice();
}
