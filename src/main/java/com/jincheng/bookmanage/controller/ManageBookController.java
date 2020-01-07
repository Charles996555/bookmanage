package com.jincheng.bookmanage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.jincheng.bookmanage.entity.Book;
import com.jincheng.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;

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

    /**
     * 展示全部书籍的详细列表
     */
    @RequestMapping("/toAgentList")
    public String toAgentList(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize, Model model){
        PageInfo<Book> page=bookService.getBookList(pageNo,pageSize);
        model.addAttribute("pageInfo",page);
        return "/backstage/tgls/agent/agent_list";
    }

    /**
     * 按照名字模糊查找
     */
    @RequestMapping("/searchBook")
    public String searchBook(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="30")int pageSize,String name, Model model){
        PageInfo<Book> page=bookService.getBookByName(pageNo,pageSize,name);
        model.addAttribute("pageInfo",page);
        return "/backstage/tgls/agent/agent_list";
    }

    /**
     * 到新增页面
     */
    @RequestMapping("/toAgentAdd")
    public String toAgentAdd(){
        return "/backstage/tgls/agent/agent_add";
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

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Integer id,Model model){
        Book book = bookService.findOneBookById(id);
        model.addAttribute("book",book);
        return "/backstage/tgls/agent/agent_update";
    }

    /**
     * 书籍的更新操作
     */
    @RequestMapping("/updateBook")
    @ResponseBody
    public String updateBook(Integer id,String name,String type,Double price,String img) throws JsonProcessingException {
        if (StringUtils.isEmpty(name)||StringUtils.isEmpty(price.toString())||StringUtils.isEmpty(type)||StringUtils.isEmpty(img)){
            return "请不要输入空的值";
        }
        Book book=new Book(id,name,type,price,img);
        String temp=bookService.updateOneBook(book);
        return new ObjectMapper().writeValueAsString(temp);
    }

    /**
     * 对书籍的添加操作
     */
    @RequestMapping("/addOneBook")
    @ResponseBody
    public String addOneBook(String name,Double price,String type,String img) throws JsonProcessingException {
        if (StringUtils.isEmpty(name)||StringUtils.isEmpty(price.toString())||StringUtils.isEmpty(type)||StringUtils.isEmpty(img)){
            return "您输入的信息为空，请检查";
        }
        Book book=new Book(0,name,type,price,img);
        String temp=bookService.addOneBook(book);
        return new ObjectMapper().writeValueAsString(temp);
    }

    /**
     * 删除书籍的操作
     */
    @RequestMapping("/deleteOneBook")
    @ResponseBody
    public String deleteOneBook(Integer id) throws JsonProcessingException {
        String temp=bookService.deleteOneBook(id);
        return new ObjectMapper().writeValueAsString(temp);
    }
}
