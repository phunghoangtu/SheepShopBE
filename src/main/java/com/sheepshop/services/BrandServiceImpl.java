package com.sheepshop.services;

import com.sheepshop.entitys.Brand;
import com.sheepshop.repositorys.BrandRepository;
import com.sheepshop.services.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getBrandList() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }


}
