package com.sheepshop.rest;

import com.sheepshop.model.req.AddressKhachLe;
import com.sheepshop.model.req.AddressRequest;
import com.sheepshop.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/address")
public class AddressRest {
    @Autowired
    private AddressService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressByCustomer(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getAddressByCustomer(id));
    }
    @GetMapping("/getBill/{code}")
    public ResponseEntity<?> getBill(@PathVariable("code") String code){
        return ResponseEntity.ok(service.getAddressByBill(code));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getAddressById(id));
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody AddressKhachLe addressKhachLe){
        return ResponseEntity.ok(service.add(addressKhachLe));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addAddresss(@RequestBody AddressRequest request){
        return ResponseEntity.ok(service.addAddress(request));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}
