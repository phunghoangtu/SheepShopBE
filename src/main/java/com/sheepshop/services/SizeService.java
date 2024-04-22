package com.sheepshop.services;

import com.sheepshop.entitys.Size;
import com.sheepshop.repositorys.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getSizeList() {
        return sizeRepository.findAll();
    }

    public Size findById(Long id) {
        return sizeRepository.findById(id).get();
    }

    public void save(Size size) {
        sizeRepository.save(size);
    }

}
