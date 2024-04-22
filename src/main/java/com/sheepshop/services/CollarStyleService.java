package com.sheepshop.services;

import com.sheepshop.entitys.CollarStyle;
import com.sheepshop.repositorys.CollarStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollarStyleService {

    @Autowired
    private CollarStyleRepository collarStyleRepository;


    public List<CollarStyle> getCollarStyleList() {
        return collarStyleRepository.findAll();
    }


    public CollarStyle findById(Long id) {
        return collarStyleRepository.findById(id).get();
    }


    public void save(CollarStyle collarStyle) {
            collarStyleRepository.save(collarStyle);
    }


}
