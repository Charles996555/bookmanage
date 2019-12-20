package com.jincheng.bookmanage.service.impl;

import com.jincheng.bookmanage.dao.BookDao;
import com.jincheng.bookmanage.dto.BookDto;
import com.jincheng.bookmanage.entity.Book;
import com.jincheng.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookDao dao;

    @Override
    public BookDto findByPage(Integer page) {
        int index=(page-1)*9;
        List<Book> books=dao.findByPage(index);

        int totalCount=dao.findCount();
        int totalPage=totalCount%9==0?totalCount/9:(totalCount/9+1);
        BookDto dto=new BookDto(page,totalPage,books);
        return dto;
    }

    @Override
    public BookDto findByBookType(String type, Integer page) {
        int index=(page-1)*9;
        List<Book> books=dao.findByBookType(type,index);

        int totalCount=dao.findCountByType(type);
        int totalPage=totalCount%9==0?totalCount/9:(totalCount/9+1);
        BookDto dto=new BookDto(page,totalPage,books);
        return dto;
    }

    @Override
    public Book findOneBookById(Integer id) {
        return dao.findOneBookById(id);
    }

    @Override
    public String findImgByBookName(String name) {
        return dao.findImgByBookName(name);
    }
}
