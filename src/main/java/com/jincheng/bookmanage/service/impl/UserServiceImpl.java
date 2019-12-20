package com.jincheng.bookmanage.service.impl;

import com.jincheng.bookmanage.dao.UserDao;
import com.jincheng.bookmanage.entity.User;
import com.jincheng.bookmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public Boolean userIsExist(String username, String password) {
        User user=dao.findUserByUsername(username);
        if (user!=null&&user.getPassword().equals(password)){
            return true;
        }else return false;
    }
}
