package com.sheepshop.services;


import com.sheepshop.entitys.BillDetail;
import com.sheepshop.model.req.BillDetailRequest;
import com.sheepshop.model.resp.BillDaBanResponse;
import com.sheepshop.model.resp.TKSanPham;
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

    public List<TKSanPham> getTKSanPham(){
        return repository.getTKSanPham();
    }

    public BillDetail updateBillDetail(Integer id,BillDetailRequest request){
        BillDetail billDetail = repository.getById(id);
        billDetail.setQuantity(request.getQuantity());
        billDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(billDetail);
    }



}
