package com.sheepshop.services;

import com.sheepshop.entitys.UserRole;
import com.sheepshop.repositorys.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

}
