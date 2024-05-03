package com.spring.sheepshop.rest;

import com.spring.sheepshop.entity.OperationHistory;
import com.spring.sheepshop.service.OperationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/operationhistory")
public class OperationHistoryRest {
    @Autowired
    OperationHistoryService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody OperationHistory operationHistory){
        return ResponseEntity.ok(service.add(operationHistory));
    }

}
