package com.sheepshop.services;


import com.sheepshop.entitys.Bill;
import com.sheepshop.entitys.BillDetail;
import com.sheepshop.entitys.ProductDetail;
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
