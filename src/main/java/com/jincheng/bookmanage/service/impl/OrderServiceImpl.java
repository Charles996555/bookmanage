package com.jincheng.bookmanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jincheng.bookmanage.dao.OrderDao;
import com.jincheng.bookmanage.dto.BookCartDto;
import com.jincheng.bookmanage.entity.Order;
import com.jincheng.bookmanage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao dao;

    @Override
    public void saveAddMessage(Double totalPrice,HttpSession session) {
        Map<String, List<BookCartDto>> cartMap = (Map<String, List<BookCartDto>>) session.getAttribute("cartMap");
        String username = (String) session.getAttribute("loginUser");
        List<BookCartDto> listBookCartDto = cartMap.get(username);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createtime=sdf.format(new Date());
        String ordernumber="";
        for (int i=0;i<15;i++){
            //赋予一个随机订单号
            int temp = (int)((Math.random()) * 10);
            ordernumber+=temp;
        }

        Order order=new Order(0,ordernumber,username,createtime,"0000-00-00 00:00:00",totalPrice,0);
        dao.saveAddMessage(order.getOrdernumber(),order.getUsername(),order.getCreatetime(),order.getUpdatetime(),totalPrice,order.getIspay());

    }

    @Override
    public PageInfo<Order> getOrderList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Order> list = dao.findAllOrders();
        //用PageInfo对结果进行包装
        PageInfo<Order> page = new PageInfo<Order>(list);
        return page;
    }

    @Override
    public String deleteOrder(Integer id) {

        dao.deleteOrder(id);
        return "删除成功！";
    }

    @Override
    public Double getOrderTotalPrice() {
        return dao.getOrderTotalPrice();
    }

    @Override
    public Double getPayOrderPrice() {
        return dao.getPayOrderPrice();
    }
}
