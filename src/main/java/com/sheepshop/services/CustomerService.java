package com.sheepshop.services;

import com.sheepshop.entitys.Customer;
import com.sheepshop.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // de tai khach hang
    @Cacheable(value = "customerCache", key = "#username")
    public Customer getByUsername(String username){
        return customerRepository.getByUsername(username);
    }


}
