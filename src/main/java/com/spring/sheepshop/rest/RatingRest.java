package com.spring.sheepshop.rest;

import com.spring.sheepshop.request.DanhGiaRequest;
import com.spring.sheepshop.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/rating")
public class RatingRest {
    @Autowired
    RatingService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DanhGiaRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
