package com.jincheng.bookmanage.dao;

import com.jincheng.bookmanage.entity.Manage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    * 根据用户名查找角色id
    * */
    @Select("select roleid from manage where username=#{username}")
    Integer findRoleIdByUsername(String username);

    /**
     * 根据用户名查找对应的管理员信息
     */
    @Select("select * from manage where username=#{username}")
    Manage findManagerByManagename(String username);

    @Update("UPDATE manage SET `password`=#{password} where username=#{username}")
    void changePassword(String username, String password);
}
