package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.*;
import com.spring.sheepshop.repository.BillDetailRepository;
import com.spring.sheepshop.request.BillDetailRequest;
import com.spring.sheepshop.response.BillDaBanResponse;
import com.spring.sheepshop.response.TKSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService {
    @Autowired
    BillDetailRepository repository;

    public BillDetail addBillDetail(BillDetailRequest request){
        BillDetail billDetail = new BillDetail();
        billDetail.setBill(Bill.builder().Id(request.getIdBill()).build());
        billDetail.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        billDetail.setIdColor(request.getIdColor());
        billDetail.setIdSize(request.getIdSize());
        billDetail.setQuantity(request.getQuantity());
        billDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(billDetail);
    }
    public BillDetail updateBillDetail(Integer id,BillDetailRequest request){
        BillDetail billDetail = repository.getById(id);
        billDetail.setQuantity(request.getQuantity());
        billDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(billDetail);
    }
    public List<BillDetail> getAllbyBill(String code){
        return repository.getAllByBill(code);
    }

    public void deleteBillDetail(Integer id){
        BillDetail billDetail = repository.getById(id);
        repository.delete(billDetail);
    }
    public void deleteBillDetailByCode(String code){
        List<BillDetail> list = repository.getAllByBill(code);
        for (BillDetail billDetail: list
             ) {
            repository.delete(billDetail);

        }
    }
    public BillDetail getById(Integer id){
        BillDetail billDetail = repository.getById(id);
        return billDetail;
    }
    public List<BillDaBanResponse> getAllByIdProduct(Integer id){
        return repository.getAllByIdProduct(id);
    }

    public List<TKSanPham> getTKSanPham(){
        return repository.getTKSanPham();
    }

}
