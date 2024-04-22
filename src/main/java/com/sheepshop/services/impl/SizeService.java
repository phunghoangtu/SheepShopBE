package com.sheepshop.services.impl;

import com.sheepshop.entitys.Size;

import java.util.List;

public interface SizeService {

    List<Size> getSizeList();

    Size findById(Integer id);

    void save(Size size);

}
