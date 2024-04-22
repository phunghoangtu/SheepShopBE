package com.sheepshop.services;

import com.sheepshop.entitys.Brand;
import com.sheepshop.repositorys.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;


    public List<Brand> getBrandList() {
        return brandRepository.findAll();
    }


    public Brand findById(Long id) {
        return brandRepository.findById(id).get();
    }


    public void save(Brand brand) {
        brandRepository.save(brand);
    }


}
