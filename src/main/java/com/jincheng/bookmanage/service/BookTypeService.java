package com.jincheng.bookmanage.service;

import com.jincheng.bookmanage.entity.BookType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BookTypeService {

    public List<BookType> findAll();
}
