package com.jincheng.bookmanage.service.impl;

import com.jincheng.bookmanage.dto.BookCartDto;
import com.jincheng.bookmanage.service.BookService;
import com.jincheng.bookmanage.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    BookService service;

    @Override
    public void addShopCart(String name, String img, Double price, Integer count, HttpSession session) {
        //把商品通过session添加到购物车
        String username = (String) session.getAttribute("loginUser");
        img=service.findImgByBookName(name);
        double totalPrice=price*count;
        DecimalFormat df = new DecimalFormat("#.00");
        totalPrice=Double.parseDouble(df.format(totalPrice));
        BookCartDto bookCartDto=new BookCartDto(name,img,price,count,totalPrice);
        List<BookCartDto> listBookCartDto=null;
        Map<String,List<BookCartDto>> cartMap = null;
        //判断该用户购物车是否有东西
        if (session.getAttribute("cartMap")!=null){
            cartMap= (Map<String, List<BookCartDto>>) session.getAttribute("cartMap");
            if (cartMap.get(username)!=null){
                listBookCartDto=cartMap.get(username);
                listBookCartDto.add(bookCartDto);
                cartMap.put(username,listBookCartDto);

            }else {
                listBookCartDto = new ArrayList<>();
                listBookCartDto.add(bookCartDto);
                cartMap.put(username,listBookCartDto);
            }
            session.setAttribute("cartMap",cartMap);
        }else{
            //map为空
            cartMap=new HashMap<>();
            listBookCartDto = new ArrayList<>();
            listBookCartDto.add(bookCartDto);
            cartMap.put(username,listBookCartDto);
            session.setAttribute("cartMap",cartMap);

        }
        System.out.println(cartMap);
    }

    @Override
    public String showCartList(Model model, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        String str="操作成功";
        Map<String,List<BookCartDto>> cartMap = (Map<String, List<BookCartDto>>) session.getAttribute("cartMap");
        if (session.getAttribute("cartMap")==null){
            return "您的购物车为空,请重新选择";
        }
        List<BookCartDto> listBookCartDto = cartMap.get(username);
        model.addAttribute("lists",listBookCartDto);
        return str;
    }

    @Override
    public Double showTotalPrice(HttpSession session) {
        //统计总总总总总价
        Map<String,List<BookCartDto>> cartMap = (Map<String, List<BookCartDto>>) session.getAttribute("cartMap");
        String username = (String) session.getAttribute("loginUser");
        List<BookCartDto> listBookCartDto = cartMap.get(username);
        Double total=0.00;
        for (int i=0;i<listBookCartDto.size();i++){
            total+=listBookCartDto.get(i).getTotalPrice();
        }
        return  total;
    }


}
