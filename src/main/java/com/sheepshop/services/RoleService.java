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



}
