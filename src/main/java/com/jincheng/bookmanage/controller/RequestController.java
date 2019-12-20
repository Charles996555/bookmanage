package com.jincheng.bookmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zyx
 */
@Controller
public class RequestController {

    @RequestMapping("/tobgLoginPage")
    public String tobgPage(){
        return "backstage/login1";
    }

    @RequestMapping("/toftIndex")
    public String toftIndex(){
        return "front/index";
    }

    @RequestMapping("/toShopGrid")
    public String toShopGrid(){
        return "front/shop-grid";
    }

    @RequestMapping("/toqdAPI")
    public String toqdAPI(){
        return "/backstage/tgls/qdAPI";
    }
}
