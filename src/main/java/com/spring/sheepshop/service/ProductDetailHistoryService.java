package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.ProductDetail;
import com.spring.sheepshop.entity.ProductDetailHistory;
import com.spring.sheepshop.repository.ProductDetailHistoryRepository;
import com.spring.sheepshop.request.ProductDetailHistoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailHistoryService {
    @Autowired
    private ProductDetailHistoryRepository repository;

    public ProductDetailHistory add(ProductDetailHistoryRequest request){
        ProductDetailHistory productDetailHistory = new ProductDetailHistory();
        productDetailHistory.setImageMain(request.getImageMain());
        productDetailHistory.setImageList(request.getImageList());
        productDetailHistory.setUpdateDate(request.getUpdateDate());
        productDetailHistory.setUpdateBy(request.getUpdateBy());
        productDetailHistory.setName(request.getName());
        productDetailHistory.setPrice(request.getPrice());
        productDetailHistory.setDescription(request.getDescription());
        productDetailHistory.setIdCategory(request.getIdCategory());
        productDetailHistory.setIdBrand(request.getIdBrand());
        productDetailHistory.setIdMaterial(request.getIdMaterial());
        productDetailHistory.setIdColor_Size_Quantity(request.getIdColor_Size_Quantity());
        productDetailHistory.setIdDesign(request.getIdDesign());
        productDetailHistory.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        productDetailHistory.setIdVoucher(request.getIdVoucher());
        productDetailHistory.setDiscount(request.getDiscount());
        productDetailHistory.setDiscountDate(request.getDiscountDate());
        productDetailHistory.setSupplierName(request.getSupplierName());
        productDetailHistory.setSupplierAddress(request.getSupplierAddress());
        productDetailHistory.setSupplierPhone(request.getSupplierPhone());
        productDetailHistory.setSupplierAgree(request.getSupplierAgree());
       return repository.save(productDetailHistory);
    }
    public List<ProductDetailHistory> getAllById(Integer id){
        return repository.getAllById(id);
    }
    public ProductDetailHistory getById(Integer id){
        return repository.getById(id);
    }
}
