package com.jincheng.bookmanage.service;

import org.springframework.ui.Model;

public interface ManageService {
    boolean findManagerIfTrue(String username, String password, String role, Model model);
}
