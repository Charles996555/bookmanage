package com.jincheng.bookmanage.dao;

import com.jincheng.bookmanage.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {
    void saveAddMessage(String ordernumber,String username,String createtime,String updatetime,Double totalprice,Integer ispay);

    @Select("select * from `order`")
    List<Order> findAllOrders();

    @Delete("delete from `order` where id=#{id} ")
    void deleteOrder(Integer id);

    @Select("select sum(totalprice) from `order`")
    Double getOrderTotalPrice();

    @Select("select sum(totalprice) from `order` where ispay <> 0")
    Double getPayOrderPrice();
}
