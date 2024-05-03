package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.Rating;
import com.spring.sheepshop.entity.RatingImage;
import com.spring.sheepshop.repository.RatingImageRepository;
import com.spring.sheepshop.request.RatingImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingImageService {
    @Autowired
     RatingImageRepository repository;

    public RatingImage add(RatingImageRequest request){
        RatingImage ratingImage = new RatingImage();
        ratingImage.setUrl(request.getUrl());
        ratingImage.setRating(Rating.builder().Id(request.getIdRating()).build());
        return repository.save(ratingImage);
    }
}
