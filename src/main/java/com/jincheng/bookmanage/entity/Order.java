package com.jincheng.bookmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String ordernumber;
    private String username;
    private String createtime;
    private String updatetime;
    private Double totalprice;
    private Integer ispay=0;
}
