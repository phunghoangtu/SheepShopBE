package com.sheepshop.rest;

import com.sheepshop.model.req.ProductVoucherRequest;
import com.sheepshop.services.ProductVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productvoucher")
public class ProductVoucherRest {
    @Autowired
    private ProductVoucherService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductVoucherRequest product_voucher){
        return ResponseEntity.ok(service.add(product_voucher));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/getbyproduct/{id}")
    public ResponseEntity<?> getbyproduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getAllByProduct(id));
    }
}
