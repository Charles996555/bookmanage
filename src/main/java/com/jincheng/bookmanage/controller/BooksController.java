package com.jincheng.bookmanage.controller;

import com.jincheng.bookmanage.dto.BookDto;
import com.jincheng.bookmanage.entity.Book;
import com.jincheng.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class BooksController {

    @Autowired
    BookService service;

    //展示全部书籍
    @RequestMapping("/showBooks")
    @ResponseBody
    public BookDto showBooks(int page, HttpSession session){
        BookDto dto = service.findByPage(page);
        return dto;
    }

    //按查找展示书籍
    @RequestMapping("/showByFindBookType")
    @ResponseBody
    public BookDto showByFindBookType(Integer findType,Integer page){
        BookDto dto = null;
        String type="";
        switch (findType){
            case 1:
                type="畅销书";
                dto=service.findByBookType(type,page);
                return dto;

            case 2:
                type="历史书";
                dto=service.findByBookType(type,page);
                return dto;

            case 3:
                type="文学书";
                dto=service.findByBookType(type,page);
                return dto;

            case 4:
                type="儿童书";
                dto=service.findByBookType(type,page);
                return dto;

            case 5:
                type="学习书";
                dto=service.findByBookType(type,page);
                return dto;

        }
        return dto;
    }

    //精确搜索书籍
    @RequestMapping("searchBook")
    @ResponseBody
    public Book searchBook(String name){
        //待写
        Book book=null;
        return book;
    }

    //显示单一书本的详细信息
    @RequestMapping("toSingleProduct")
    public String toSingleProduct(Integer id, Model model){
        model.addAttribute("book",service.findOneBookById(id));
        return "/front/single-product";
    }

}
