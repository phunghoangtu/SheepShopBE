package com.sheepshop.rest;

import com.sheepshop.entitys.OperationHistory;
import com.sheepshop.services.OperationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/operationhistory")
public class OperationHistoryRest {
    @Autowired
    private OperationHistoryService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody OperationHistory operationHistory){
        return ResponseEntity.ok(service.add(operationHistory));
    }

}
