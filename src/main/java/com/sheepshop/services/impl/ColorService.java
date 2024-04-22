package com.sheepshop.services.impl;

import com.sheepshop.entitys.Color;

import java.util.List;

public interface ColorService {

    List<Color> getColorList();

    Color findById(Long id);

    void save(Color color);

}
