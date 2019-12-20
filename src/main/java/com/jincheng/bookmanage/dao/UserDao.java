package com.jincheng.bookmanage.dao;

import com.jincheng.bookmanage.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where username=#{username}")
    User findUserByUsername(String username);
}
