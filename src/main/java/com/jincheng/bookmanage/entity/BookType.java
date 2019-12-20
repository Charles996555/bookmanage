package com.jincheng.bookmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookType {
    private Integer id;
    private String typename;
    private Integer count;
}
