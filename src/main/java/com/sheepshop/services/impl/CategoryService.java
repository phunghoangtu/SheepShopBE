package com.sheepshop.services.impl;

import com.sheepshop.entitys.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoryList();

    Category findById(Integer id);

    void save(Category category);

    List<Category> getAllAPI();

}
