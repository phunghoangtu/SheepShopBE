package com.sheepshop.rest;

import com.sheepshop.entitys.Bill;
import com.sheepshop.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bill/billTaiQuay")
public class SellRest {

    @Autowired
    private BillService billService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(billService.getBillChuaThanhToan());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBill(@RequestBody Bill bill) {
        return ResponseEntity.ok(billService.addBill(bill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBillById(@PathVariable Integer id) {
        // Xóa bản ghi
        return ResponseEntity.ok(billService.deleteBillById(id));
    }

}
