package com.chy.webchatserver.dao;

import com.chy.webchatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    public User findUserByUsername(String username);
}
