package com.jincheng.bookmanage.controller;

import com.github.pagehelper.PageInfo;
import com.jincheng.bookmanage.entity.Book;
import com.jincheng.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 张雨潇
 * @Date: 2020/1/3 9:18
 */

@Controller
@RequestMapping("/manageBook")
public class ManageBookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/toAgentList")
    public String toAgentList(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize, Model model){
        PageInfo<Book> page=bookService.getBookList(pageNo,pageSize);
        model.addAttribute("pageInfo",page);
        return "/backstage/tgls/agent/agent_list";
    }

    /**
     * pageNo:当前页
     * pageSize:每页的条数
     */
    @RequestMapping("/showAllBooks")
    @ResponseBody
    public PageInfo<Book> showAllBooks(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize, Model model){
        PageInfo<Book> page=bookService.getBookList(pageNo,pageSize);
        return page;
    }
}
