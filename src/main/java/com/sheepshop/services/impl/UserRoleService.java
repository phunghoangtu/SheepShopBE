package com.sheepshop.services.impl;

import com.sheepshop.entitys.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getAll();

    void save(UserRole userRole);

}
