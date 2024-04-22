package com.sheepshop.services.impl;

import com.sheepshop.entitys.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAll();

    void save(Role role);

    Role findByName(String name);

    Role findById(Long id);

}
