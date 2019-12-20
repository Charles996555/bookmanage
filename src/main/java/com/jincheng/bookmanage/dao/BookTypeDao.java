package com.jincheng.bookmanage.dao;

import com.jincheng.bookmanage.entity.BookType;

import java.util.List;

public interface BookTypeDao {
    List<BookType> findAll();
}
