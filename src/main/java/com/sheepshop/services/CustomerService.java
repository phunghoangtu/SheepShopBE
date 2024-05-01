package com.sheepshop.services;

import com.sheepshop.entitys.Customer;
import com.sheepshop.model.req.CapNhatProfile;
import com.sheepshop.model.req.ChangeForm;
import com.sheepshop.model.req.RegisterForm;
import com.sheepshop.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Instant;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    // de tai khach hang
    public Customer getById(Integer Id){
        Customer customer = customerRepository.getById(Id);
        return customer;
    }
    // de tai khach hang
    public Customer getByUsername(String username){
        return customerRepository.getByUsername(username);
    }

    public String genCode(){
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "KH" + timestamp;
        return code;
    }
    // đăng ký
    public Customer register(RegisterForm form){
        Customer customer = new Customer();
        customer.setCode(genCode());
        customer.setEmail(form.getEmail());
        customer.setFullname(form.getFullname());
        customer.setUsername(form.getUsername());
        customer.setPassword(form.getPassword());
        customer.setCreateDate(new Date());
        customer.setStatus(0);
        return customerRepository.save(customer);
    }
    // đổi mật khẩu
    public Customer change(Integer idCustomer, ChangeForm form){
        Customer customer = customerRepository.getById(idCustomer);
        customer.setPassword(form.getRePasswordMoi());
        customer.setUpdateDate(new Date());
        return customerRepository.save(customer);
    }

    //cập nhật profile
    public Customer updateprofile(Integer idCustomer, CapNhatProfile form){
        Customer customer = customerRepository.getById(idCustomer);
        customer.setFullname(form.getFullname());
        customer.setEmail(form.getEmail());
        customer.setPhone(form.getPhone());
        customer.setGender(form.getGender());
        customer.setImage(form.getImage());
        customer.setUpdateDate(new Date());
        return customerRepository.save(customer);
    }




}
