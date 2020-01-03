package com.jincheng.bookmanage.service;


import com.github.pagehelper.PageInfo;
import com.jincheng.bookmanage.dto.BookDto;
import com.jincheng.bookmanage.entity.Book;


public interface BookService {

    public BookDto findByPage(Integer page);
    public BookDto findByBookType(String type,Integer page);

    Book findOneBookById(Integer id);
    String findImgByBookName(String name);

    PageInfo<Book> getBookList(int pageNo, int pageSize);
}
