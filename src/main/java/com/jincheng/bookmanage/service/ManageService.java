package com.jincheng.bookmanage.service;

import com.jincheng.bookmanage.entity.Manage;
import org.springframework.ui.Model;

public interface ManageService {
    boolean findManagerIfTrue(String username, String password, String role, Model model);

    Manage findManagerByManagename(String username);

    String changePassword(String username, String oldpassword, String password, String password2);
}
