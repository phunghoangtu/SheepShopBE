package com.sheepshop.services;

import com.sheepshop.entitys.Material;
import com.sheepshop.repositorys.MaterialRepository;
import com.sheepshop.services.impl.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> getMaterialList() {
        return materialRepository.findAll();
    }

    @Override
    public Material findById(Long id) {
        return materialRepository.findById(id).get();
    }

    @Override
    public void save(Material material) {
        materialRepository.save(material);
    }

}
