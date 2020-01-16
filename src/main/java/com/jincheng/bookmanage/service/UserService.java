package com.jincheng.bookmanage.service;

public interface UserService {
    Boolean userIsExist(String username,String password);

    String register(String username, String password);
}
