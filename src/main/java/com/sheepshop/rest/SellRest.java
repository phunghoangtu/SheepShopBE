package com.sheepshop.rest;

import com.sheepshop.model.req.BillTaiQuayRequest;
import com.sheepshop.services.BillDetailService;
import com.sheepshop.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bill")
public class SellRest {

    @Autowired
    private BillService billService;

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping("/getbystatus/{status}")
    public ResponseEntity<?> getbystatus(@PathVariable("status") Integer status){
        return ResponseEntity.ok(billService.getAllByStatus(status));
    }

    @PostMapping("/billTaiQuay")
    public ResponseEntity<?> billTaiQuay(@RequestBody BillTaiQuayRequest request){
        return ResponseEntity.ok(billService.addBillTaiQuay(request));
    }

    @GetMapping("/getallbybill/{code}")
    public ResponseEntity<?> getallbybill(@PathVariable("code") String code){
        return ResponseEntity.ok(billDetailService.getAllbyBill(code));
    }

    @GetMapping("/getallbyproduct/{id}")
    public ResponseEntity<?> getallbyproduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(billDetailService.getAllByIdProduct(id));
    }

}
