package com.chy.webchatserver.dao;

import com.chy.webchatserver.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author chy
 * @Date 2019/4/29
 * @Email 1625640688@qq.com
 */
public interface MenuDao extends JpaRepository<Menu,Long> {
    List<Menu> findAll();
}
