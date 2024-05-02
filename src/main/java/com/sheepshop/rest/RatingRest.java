package com.sheepshop.rest;

import com.sheepshop.model.req.DanhGiaRequest;
import com.sheepshop.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rating")
public class RatingRest {
    @Autowired
    private RatingService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DanhGiaRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
