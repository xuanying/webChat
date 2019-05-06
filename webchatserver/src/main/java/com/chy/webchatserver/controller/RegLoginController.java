package com.chy.webchatserver.controller;

import com.chy.webchatserver.entity.RespBean;
import com.chy.webchatserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegLoginController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/login_p")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录！");
    }

    @GetMapping("/admin/test")
    public String admintest(){
        return "admin";
    }

    @GetMapping("/home/test")
    public String hometest(){
        return "home";
    }
}
