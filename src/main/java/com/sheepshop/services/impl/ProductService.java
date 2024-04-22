package com.sheepshop.services.impl;

import com.sheepshop.entitys.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void save(Product product);

    Product findById(Long id);

    Product findByName(String name);

    List<Product> getAllAPI();

}
