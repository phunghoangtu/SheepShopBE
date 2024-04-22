package com.sheepshop.services;

import com.sheepshop.entitys.CollarStyle;
import com.sheepshop.repositorys.CollarStyleRepository;
import com.sheepshop.services.impl.CollarStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollarStyleServiceImpl implements CollarStyleService {

    @Autowired
    private CollarStyleRepository collarStyleRepository;

    @Override
    public List<CollarStyle> getCollarStyleList() {
        return collarStyleRepository.findAll();
    }

    @Override
    public CollarStyle findById(Long id) {
        return collarStyleRepository.findById(id).get();
    }

    @Override
    public void save(CollarStyle collarStyle) {
            collarStyleRepository.save(collarStyle);
    }


}
