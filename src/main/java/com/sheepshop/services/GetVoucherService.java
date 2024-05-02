package com.sheepshop.services;

import com.sheepshop.entitys.Voucher;
import com.sheepshop.repositorys.GetVoucherRepo;
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
