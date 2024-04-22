package com.sheepshop.services;

import com.sheepshop.entitys.Material;
import com.sheepshop.repositorys.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;


    public List<Material> getMaterialList() {
        return materialRepository.findAll();
    }


    public Material findById(Long id) {
        return materialRepository.findById(id).get();
    }


    public void save(Material material) {
        materialRepository.save(material);
    }

}
