package com.jincheng.bookmanage.dao;

import com.jincheng.bookmanage.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> findByPage(int index);
    Integer findCount();
    List<Book> findByBookType(String type,Integer index);
    Integer findCountByType(String type);

    Book findOneBookById(Integer id);
    String findImgByBookName(String name);
}
