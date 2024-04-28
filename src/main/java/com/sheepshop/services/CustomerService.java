package com.sheepshop.services;

import com.sheepshop.entitys.Customer;
import com.sheepshop.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

}
