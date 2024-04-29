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
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> getAllByEmployee(@PathVariable("name") String name){
        return ResponseEntity.ok(employeeService.getAllbyName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable("usernmae") String name){
        return ResponseEntity.ok(employeeService.getByUsername(name));
    }


    @GetMapping("/filter")
    public ResponseEntity<?> getAllByFilter(@RequestParam(name = "idRole",required = false) Integer idRole){
        return ResponseEntity.ok(employeeService.getAllByFilter(idRole));
    }


}
