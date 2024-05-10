package com.spring.sheepshop.rest;

import com.spring.sheepshop.request.RatingImageRequest;
import com.spring.sheepshop.service.RatingImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratingimage")
public class RatingImageRest {
    @Autowired
    RatingImageService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody RatingImageRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
