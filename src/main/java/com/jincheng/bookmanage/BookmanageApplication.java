package com.jincheng.bookmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jincheng.bookmanage.dao")
public class BookmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanageApplication.class, args);
    }

}
