package com.sheepshop.rest;

import com.sheepshop.model.req.RatingImageRequest;
import com.sheepshop.services.RatingImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ratingimage")
public class RatingImageRest {
    @Autowired
    private RatingImageService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody RatingImageRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
