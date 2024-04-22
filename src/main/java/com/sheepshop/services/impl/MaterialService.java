package com.sheepshop.services.impl;

import com.sheepshop.entitys.Material;

import java.util.List;

public interface MaterialService {

    List<Material> getMaterialList();

    Material findById(Long id);

    void save(Material material);

}
