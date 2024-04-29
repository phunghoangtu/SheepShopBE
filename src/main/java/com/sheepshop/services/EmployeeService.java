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

    @Cacheable(value = "employeeCache", key = "#id")
    public Employee getById(Integer id){
        return employeeRepository.getById(id);
    }

    @Cacheable(value = "employeeCache", key = "#username")
    public Employee getByUsername(String username){
        return employeeRepository.getByUsername(username);
    }

    @Cacheable(value = "employeeCache", key = "#name")
    public List<Employee> getAllbyName(String name){
        return employeeRepository.searchByName('%'+name+'%');
    }

    public List<Employee> getAllByFilter(Integer role_id){
        return employeeRepository.getEmployeeByRole(role_id);
    }


}
