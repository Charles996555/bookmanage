package com.jincheng.bookmanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<Book> getBookList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Book> list = dao.findAllBooks();
        //用PageInfo对结果进行包装
        PageInfo<Book> page = new PageInfo<Book>(list);
        return page;

    }

    @Override
    public String updateOneBook(Book book) {
        if (book.getPrice()==null||book.getName()==null||book.getId()==null||book.getImg()==null||book.getType()==null){
            return "请不要输入空的值";
        }
        Book oldBook = dao.findOneBookById(book.getId());
        if (book.equals(oldBook)){
            return "您没有进行任何修改，请重试！！！";
        }
        if (book.getName().length()>20){
            return "您输入的书籍名称不合法，请重试！！！";
        }
        if (book.getPrice()<0){
            return "您输入的价格不合法，请重试！！！";
        }
        dao.updateOneBook(book);
        return "修改成功！！！";
    }
}
