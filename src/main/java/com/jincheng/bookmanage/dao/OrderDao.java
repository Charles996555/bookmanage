package com.jincheng.bookmanage.dao;

public interface OrderDao {
    void saveAddMessage(String ordernumber,String username,String createtime,String updatetime,Double totalprice,Integer ispay);
}
