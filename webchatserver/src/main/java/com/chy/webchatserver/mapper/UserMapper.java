package com.chy.webchatserver.mapper;

import com.chy.webchatserver.entity.User;

public interface UserMapper {

    User findUserByUsername(String username);
}
