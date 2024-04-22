package com.sheepshop.services;

import com.sheepshop.entitys.Product;
import com.sheepshop.repositorys.ProductRepository;
import com.sheepshop.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAll() {
       return productRepository.findAll();

    }

    @Override
    public void save(Product product) {
            productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    
    @Override
    public List<Product> getAllAPI() {
        return productRepository.getAllAPI();
    }


}
