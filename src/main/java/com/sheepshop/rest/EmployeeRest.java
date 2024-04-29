package com.sheepshop.rest;

import com.sheepshop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {

    @Autowired
    private EmployeeService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> getAllByEmployee(@PathVariable("name") String name){
        return ResponseEntity.ok(service.getAllbyName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable("username") String name){
        return ResponseEntity.ok(service.getByUsername(name));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getAllByFilter(@RequestParam(name = "role_id",required = false) Integer role_id) {
        return ResponseEntity.ok(service.getAllByFilter(role_id));
    }


}
