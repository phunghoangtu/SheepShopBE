package com.sheepshop.rest;

import com.sheepshop.model.req.CapNhatProfile;
import com.sheepshop.model.req.EmployeeRequest;
import com.sheepshop.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import java.util.List;


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
    public ResponseEntity<?> getAllByFilter(@RequestParam(name = "idRole",required = false) Integer idRole) {
        return ResponseEntity.ok(service.getAllByFilter(idRole));
    }

    @PutMapping("/updateprofile/{id}")
    public ResponseEntity<?> updateprofile(@PathVariable("id") Integer id, @Valid @RequestBody CapNhatProfile form, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.updateprofile(id,form));
    }

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody EmployeeRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.add(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer Id, @Valid @RequestBody EmployeeRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.update(Id,request));
    }






}
