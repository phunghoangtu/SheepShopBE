package com.sheepshop.services;

import com.sheepshop.entitys.ProductDetail;
import com.sheepshop.repositorys.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository repository;
    public List<ProductDetail> getAll() {
        return repository.getAll();
    }
    public List<ProductDetail> getAll1() {
        return repository.getAll1();
    }
    public List<ProductDetail> getAllbyProductName(String name){
        return repository.getAllByProductName("%"+name+"%");
    }



}
