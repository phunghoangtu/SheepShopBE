package com.sheepshop.services.impl;

import com.sheepshop.entitys.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getBrandList();

    Brand findById(Integer id);

    void save(Brand brand);


}
