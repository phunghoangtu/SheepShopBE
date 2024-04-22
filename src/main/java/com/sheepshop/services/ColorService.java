package com.sheepshop.services;

import com.sheepshop.entitys.Color;
import com.sheepshop.repositorys.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;


    public List<Color> getColorList() {
        return colorRepository.findAll();
    }


    public Color findById(Long id) {
        return colorRepository.findById(id).get();
    }


    public void save(Color color) {
        colorRepository.save(color);
    }

}
