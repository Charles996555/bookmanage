package com.jincheng.bookmanage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCartDto {
    //存储购物车数据
    private String name;
    private String img;
    private double price;
    private Integer count;
    private double totalPrice;
}
