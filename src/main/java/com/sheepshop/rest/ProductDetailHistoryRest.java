package com.sheepshop.rest;

import com.sheepshop.model.req.ProductDetailHistoryRequest;
import com.sheepshop.services.ProductDetailHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productdetailhistory")
public class ProductDetailHistoryRest {
    @Autowired
    private ProductDetailHistoryService service;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDetailHistoryRequest productDetailHistory){
        return ResponseEntity.ok(service.add(productDetailHistory));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getAllById(id));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getbyid(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
}
