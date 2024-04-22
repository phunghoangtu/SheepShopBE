package com.sheepshop.services.impl;

import com.sheepshop.entitys.CollarStyle;

import java.util.List;

public interface CollarStyleService {

    List<CollarStyle> getCollarStyleList();

    CollarStyle findById(Long id);

    void save(CollarStyle collarStyle);

}
