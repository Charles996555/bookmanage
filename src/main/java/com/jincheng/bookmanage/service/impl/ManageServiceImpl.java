package com.jincheng.bookmanage.service.impl;

import com.jincheng.bookmanage.dao.ManageDao;
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
}
