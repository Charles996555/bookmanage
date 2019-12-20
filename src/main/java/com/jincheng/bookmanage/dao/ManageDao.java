package com.jincheng.bookmanage.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @author zyx
 */
public interface ManageDao {
    /**
    * 根据管理员账号名字查询真实的密码
    * */
    @Select("select password from manage where username=#{username}")
    String findPasswordByUsername(String username);

    /**
    *根据用户名查找角色id
    * */
    @Select("select roleid from manage where username=#{username}")
    Integer findRoleIdByUsername(String username);
}
