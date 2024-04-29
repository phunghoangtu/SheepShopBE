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



}
