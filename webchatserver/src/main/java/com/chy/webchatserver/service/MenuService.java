package com.chy.webchatserver.service;

import com.chy.webchatserver.entity.Menu;
import com.chy.webchatserver.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuService {
    @Resource
    MenuMapper menuMapper;

    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }
}
