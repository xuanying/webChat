package com.chy.webchatserver.controller;

import com.chy.webchatserver.entity.Menu;
import com.chy.webchatserver.entity.User;
import com.chy.webchatserver.service.MenuService;
import com.chy.webchatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService userService;
    @Autowired
    MenuService menuService;

    @RequestMapping("/findUser")
    public User findUser(){
        User user = (User) userService.findUserByUsername("yufei");
        System.out.println(user.getFriends().get(0).getName());
        return user;
    }

    @RequestMapping("/getAllMenu")
    public List<Menu> getAllMenus(){
        List<Menu> menuList = menuService.getAllMenu();
        return menuList;
    }

}
