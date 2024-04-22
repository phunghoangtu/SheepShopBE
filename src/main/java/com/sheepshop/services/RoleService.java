package com.sheepshop.services;

import com.sheepshop.entitys.Role;
import com.sheepshop.repositorys.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

}