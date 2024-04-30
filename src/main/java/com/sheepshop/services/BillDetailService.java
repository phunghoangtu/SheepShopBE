package com.sheepshop.services;


import com.sheepshop.entitys.BillDetail;
import com.sheepshop.model.resp.BillDaBanResponse;
import com.sheepshop.repositorys.BillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService {

    @Autowired
    private BillDetailRepository repository;

    public List<BillDetail> getAllbyBill(String code){
        return repository.getAllByBill(code);
    }

    public List<BillDaBanResponse> getAllByIdProduct(Integer id){
        return repository.getAllByIdProduct(id);
    }




}
