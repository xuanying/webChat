package com.chy.webchatserver.mapper;

import com.chy.webchatserver.entity.Role;
import com.chy.webchatserver.entity.User;

import java.util.List;

public interface UserMapper {

    User findUserByUsername(String username);
    List<User> getFriendsByUserId(Integer id);
    List<Role> getRolesByUserId(Integer id);
}
