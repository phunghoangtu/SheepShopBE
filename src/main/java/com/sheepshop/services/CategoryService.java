package com.sheepshop.services;

import com.sheepshop.entitys.Category;
import com.sheepshop.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }


    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }


    public void save(Category category) {
        categoryRepository.save(category);
    }


    public List<Category> getAllAPI() {
        return categoryRepository.getAllAPI();
    }


}
