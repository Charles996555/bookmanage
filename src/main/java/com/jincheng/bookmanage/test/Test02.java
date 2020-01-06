package com.jincheng.bookmanage.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jincheng.bookmanage.dto.BookDto;
import com.jincheng.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 张雨潇
 * @Date: 2020/1/6 10:30
 */
@Controller
@RequestMapping("/test02")
public class Test02 {

    @Autowired
    BookService bookService;


    @RequestMapping("/toTest02")
    public String toTest02(){
        return "/test/vuedemo1";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(String page) throws JsonProcessingException {
        BookDto bookDto = bookService.findByPage(Integer.parseInt(page));
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(bookDto);
    }
}
