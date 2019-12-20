package com.jincheng.bookmanage.controller;

import com.jincheng.bookmanage.entity.BookType;
import com.jincheng.bookmanage.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookTypeController {

    @Autowired
    BookTypeService service;

    @RequestMapping("showBookType")
    @ResponseBody
    public List<BookType> showBookType(){
        return service.findAll();
    }
}
