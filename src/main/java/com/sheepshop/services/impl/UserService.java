package com.sheepshop.services.impl;

import com.sheepshop.entitys.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user);

    User findByUsername(String username);

}
