package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.Voucher;
import com.spring.sheepshop.repository.VoucherRepository;
import com.spring.sheepshop.request.VoucherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    VoucherRepository repository;
    public List<Voucher> getAll(){
        return repository.getAll();
    }

    public List<Voucher> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }

    public Voucher getById(Integer Id){
        Voucher voucher = repository.getById(Id);
        return voucher;
    }

    public Voucher add(VoucherRequest request){
        Voucher voucher = new Voucher();
        voucher.setCode(request.getCode());
        voucher.setName(request.getName());
        voucher.setTypeVoucher(request.getTypeVoucher());
        voucher.setIsVoucher(request.getIsVoucher());
        voucher.setDiscount(request.getDiscount());
        voucher.setCash(request.getCash());
        voucher.setStartDate(request.getStartDate());
        voucher.setEndDate(request.getEndDate());
        voucher.setStatus(0);
        voucher.setMinimum(request.getMinimum());

        return repository.save(voucher);
    }


    public Voucher update(Integer id, VoucherRequest request){
        Voucher voucher = repository.getById(id);
        voucher.setCode(request.getCode());
        voucher.setName(request.getName());
        voucher.setTypeVoucher(request.getTypeVoucher());
        voucher.setIsVoucher(request.getIsVoucher());
        voucher.setDiscount(request.getDiscount());
        voucher.setCash(request.getCash());
        voucher.setStartDate(request.getStartDate());
        voucher.setEndDate(request.getEndDate());
        voucher.setStatus(0);
        voucher.setMinimum(Integer.valueOf(request.getMinimum()));
        return repository.save(voucher);
    }

    public Voucher delete(Integer Id){
        Voucher voucher = repository.getById(Id);
        voucher.setStatus(2);
        return repository.save(voucher);
    }



}
