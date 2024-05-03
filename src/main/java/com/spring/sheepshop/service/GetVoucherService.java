package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.Voucher;
import com.spring.sheepshop.repository.GetVoucherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVoucherService {
    @Autowired
    private GetVoucherRepo repo ;

    public List<Voucher> getAll(){
        return repo.getAll();
    }
}
