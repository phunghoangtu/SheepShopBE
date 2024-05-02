package com.sheepshop.services;

import com.sheepshop.entitys.Customer;
import com.sheepshop.entitys.ProductDetail;
import com.sheepshop.entitys.Rating;
import com.sheepshop.model.req.DanhGiaRequest;
import com.sheepshop.repositorys.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingService {
    @Autowired
    private RatingRepository repository;

    public Rating add(DanhGiaRequest request){
        Rating rating = new Rating();
        rating.setScore(request.getScore());
        rating.setNote(request.getNote());
         rating.setCreateDate(new Date());
         rating.setCustomer(Customer.builder().Id(request.getIdCustomer()).build());
         rating.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
         rating.setStatus(0);
         return repository.save(rating);
    }
}
