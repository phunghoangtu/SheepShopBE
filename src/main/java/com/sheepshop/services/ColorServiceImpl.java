package com.sheepshop.services;

import com.sheepshop.entitys.Color;
import com.sheepshop.repositorys.ColorRepository;
import com.sheepshop.services.impl.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getColorList() {
        return colorRepository.findAll();
    }

    @Override
    public Color findById(Long id) {
        return colorRepository.findById(id).get();
    }

    @Override
    public void save(Color color) {
        colorRepository.save(color);
    }

}
