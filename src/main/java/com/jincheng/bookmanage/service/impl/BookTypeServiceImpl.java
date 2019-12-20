package com.jincheng.bookmanage.service.impl;

import com.jincheng.bookmanage.dao.BookTypeDao;
import com.jincheng.bookmanage.entity.BookType;
import com.jincheng.bookmanage.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    BookTypeDao dao;

    @Override
    public List<BookType> findAll() {
        List<BookType> bookTypes = dao.findAll();
        return bookTypes;
    }
}
