package com.sheepshop.services;

import com.sheepshop.entitys.Rating;
import com.sheepshop.entitys.RatingImage;
import com.sheepshop.model.req.RatingImageRequest;
import com.sheepshop.repositorys.RatingImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingImageService {
    @Autowired
    private RatingImageRepository repository;

    public RatingImage add(RatingImageRequest request){
        RatingImage ratingImage = new RatingImage();
        ratingImage.setUrl(request.getUrl());
        ratingImage.setRating(Rating.builder().Id(request.getIdRating()).build());
        return repository.save(ratingImage);
    }
}
