package com.jincheng.bookmanage.service.impl;

import com.jincheng.bookmanage.dao.ManageDao;
import com.jincheng.bookmanage.entity.Manage;
import com.jincheng.bookmanage.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;



/**
 * @author zyx
 */
@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageDao dao;

    @Override
    public boolean findManagerIfTrue(String username, String password, String role, Model model) {
        String truePass=dao.findPasswordByUsername(username);
        Integer trueRoleId=dao.findRoleIdByUsername(username);
        Integer roleid=0;
        if (role.equals("管理员")){
            roleid=2;
        }else {
            roleid=1;
        }
        if (truePass==null){
            model.addAttribute("msg1","您输入的账号不存在，请检查");
            return false;
        }
        if (!truePass.equals(password)){
            model.addAttribute("msg1","您输入的密码错误，请检查");
            return false;
        }
        if (!roleid.equals(trueRoleId)){
            model.addAttribute("msg1","您的角色选择有误，请检查");
            return false;
        }
        model.addAttribute("msg1","登录成功");
        return true;
    }

    @Override
    public Manage findManagerByManagename(String username) {
        return dao.findManagerByManagename(username);
    }

    @Override
    public String changePassword(String username, String oldpassword, String password, String password2) {
        if (username==null){
            return "用户异常，请练习信息管理人员！";
        }
        Manage manage=dao.findManagerByManagename(username);
        if(!manage.getPassword().equals(oldpassword)){
            return "您输入的原密码有误，请重新输入！";
        }
        if(!password.equals(password2)){
            return "您两次输入的密码不相同，请检查！";
        }
        dao.changePassword(username,password);
        return "修改成功！！";
    }
}
