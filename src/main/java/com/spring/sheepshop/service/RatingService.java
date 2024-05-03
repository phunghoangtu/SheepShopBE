package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.Customer;
import com.spring.sheepshop.entity.ProductDetail;
import com.spring.sheepshop.entity.Rating;
import com.spring.sheepshop.repository.RatingRepository;
import com.spring.sheepshop.request.DanhGiaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingService {
    @Autowired
    RatingRepository repository;

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
