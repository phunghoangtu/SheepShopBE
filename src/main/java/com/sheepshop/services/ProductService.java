package com.sheepshop.services;

import com.sheepshop.entitys.Product;
import com.sheepshop.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
       return productRepository.findAll();
    }

    public void save(Product product) {
            productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getAllAPI() {
        return productRepository.getAllAPI();
    }

}
