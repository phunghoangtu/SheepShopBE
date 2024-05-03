package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.*;
import com.spring.sheepshop.repository.ProductDetailRepository;
import com.spring.sheepshop.request.ProductDetailRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    ProductDetailRepository repository;
    public List<ProductDetail> getAll() {
        return repository.getAll();
    }
    public List<ProductDetail> getAll1() {
        return repository.getAll1();
    }
    public List<ProductDetail> getAllBanChay(){
        return repository.getAllBanChay();
    }
    public List<ProductDetail> getAllbyProductName(String name){
        return repository.getAllByProductName("%"+name+"%");
    }

    public Page<ProductDetail> phanTrang(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return repository.findAll(pageable);
    }
    public ProductDetail getById(Integer id){
       ProductDetail productDetail = repository.getById(id);
       return productDetail;
    }
    public ProductDetail add(ProductDetailRequest request){
        ProductDetail productDetail = new ProductDetail();
        productDetail.setPrice(request.getPrice());
        productDetail.setDiscount(request.getDiscount());
        productDetail.setDescription(request.getDescription());
        productDetail.setProduct(Product.builder().Id(request.getIdProduct()).build());
        productDetail.setBrand(Brand.builder().Id(request.getIdBrand()).build());
        productDetail.setCategory(Category.builder().Id(request.getIdCategory()).build());
        productDetail.setDesign(Design.builder().Id(request.getIdDesign()).build());
        productDetail.setDiscountDate(request.getDiscountDate());
        productDetail.setCreateDate(new Date());
        productDetail.setStatus(0);
        return repository.save(productDetail);
    }
    public ProductDetail delete(Integer IdProductDetail){
        ProductDetail p = repository.getById(IdProductDetail);
        p.setStatus(1);
        return repository.save(p);
    }
    public ProductDetail delete1(Integer IdProductDetail){
        ProductDetail p = repository.getById(IdProductDetail);
        p.setStatus(0);
        return repository.save(p);
    }
    public ProductDetail update(Integer id,ProductDetailRequest request){
        ProductDetail productDetail = repository.getById(id);
        productDetail.setPrice(request.getPrice());
        productDetail.setDiscount(request.getDiscount());
        productDetail.setDescription(request.getDescription());
        productDetail.setBrand(Brand.builder().Id(request.getIdBrand()).build());
        productDetail.setCategory(Category.builder().Id(request.getIdCategory()).build());
        productDetail.setDesign(Design.builder().Id(request.getIdDesign()).build());
        productDetail.setDiscountDate(request.getDiscountDate());
        productDetail.setUpdateDate(new Date());
        return repository.save(productDetail);
    }
    public ProductDetail getByCode(String code){
        return repository.getByCode(code);
    }

    public List<ProductDetail> getProductByCategory(Integer id,Integer idBrand ,Integer idDesign, Integer idProduct){
        return repository.getProductByCategory(id,idBrand,idDesign,idProduct);
    }

    public Integer quantitySold(@Param("id") Integer id){
        return repository.quantitySold(id);
    }
    public Double totalSold(@Param("id") Integer id){
        return repository.totalSale(id);
    }
    public List<Voucher> getVoucher(){
        return repository.getVoucher();
    }

    public List<Voucher> getAllVoucher(){
        return repository.getAllVoucher();
    }
    public List<ProductDetail> findAll(){
        return repository.findAll();
    }

}
