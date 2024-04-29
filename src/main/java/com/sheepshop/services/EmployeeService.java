package com.sheepshop.services;

import com.sheepshop.entitys.Employee;
import com.sheepshop.repositorys.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable(value = "employeeCache", key = "'getAll'")
    public List<Employee> getAll(){
        return employeeRepository.getAll();
    }

    @Cacheable(value = "employeeCache", key = "#Id")
    public Employee getById(Integer Id){
        return employeeRepository.getById(Id);
    }

    @Cacheable(value = "employeeCache", key = "#username")
    public Employee getByUsername(String username){
        return employeeRepository.getByUsername(username);
    }


    @Cacheable(value = "employeeCache", key = "#name")
    public List<Employee> getAllbyName(String name){
        return employeeRepository.searchByName('%'+name+'%');
    }

    public List<Employee> getAllByFilter(Integer idRole){
        return employeeRepository.getEmployeeByRole(idRole);
    }


}
