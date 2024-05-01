package com.sheepshop.rest;

import com.sheepshop.model.req.BillTaiQuayRequest;
import com.sheepshop.services.BillDetailService;
import com.sheepshop.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @GetMapping("/gettkngay")
    public ResponseEntity<?> gettkngay(){
        return ResponseEntity.ok(billService.getTKNgay());
    }

    @GetMapping("/gettkthang")
    public ResponseEntity<?> gettkthang(){
        return ResponseEntity.ok(billService.getTKThang());
    }
    @GetMapping("/gettkslthang")
    public ResponseEntity<?> gettkslthang(){
        return ResponseEntity.ok(billService.getTKSLThang());
    }
    @GetMapping("/gettksoluonghd")
    public ResponseEntity<?> gettksoluonghd(@RequestParam("tungay")String tungay,
                                            @RequestParam("denngay") String denngay){
        return ResponseEntity.ok(billService.getTKSoLuongHD(tungay,denngay));
    }
    @GetMapping("/gettksoluonghdstatus")
    public ResponseEntity<?> gettksoluonghdstatus(@RequestParam("tungay")String tungay,
                                                  @RequestParam("denngay") String denngay){
        return ResponseEntity.ok(billService.getTKSoLuongHDStatus(tungay,denngay));
    }
    @GetMapping("/gettksoluongsp")
    public ResponseEntity<?> gettksoluongsp(@RequestParam("tungay")String tungay,
                                            @RequestParam("denngay") String denngay){
        return ResponseEntity.ok(billService.getTKSoLuongSanPham(tungay,denngay));
    }
    @GetMapping("/gettksanpham")
    public ResponseEntity<?> gettksanpham(){
        return ResponseEntity.ok(billDetailService.getTKSanPham());
    }

}
