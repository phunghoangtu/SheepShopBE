package com.sheepshop.services;

import com.sheepshop.entitys.Employee;
import com.sheepshop.entitys.Role;
import com.sheepshop.model.req.CapNhatProfile;
import com.sheepshop.model.req.ChangeForm;
import com.sheepshop.model.req.EmployeeRequest;
import com.sheepshop.repositorys.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Cacheable(value = "employeeCache", key = "'getAll'")
    public List<Employee> getAll(){
        return repository.getAll();
    }

    @Cacheable(value = "employeeCache", key = "#id")
    public Employee getById(Integer id){
        return repository.getById(id);
    }

    @Cacheable(value = "employeeCache", key = "#username")
    public Employee getByUsername(String username){
        return repository.getByUsername(username);
    }

    @Cacheable(value = "employeeCache", key = "#name")
    public List<Employee> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }

    public List<Employee> getAllByFilter(Integer role_id){
        return repository.getEmployeeByRole(role_id);
    }

    private String getNextCode() {
        String biggestMa = repository.getBiggestMa();
        int currentCode = 0;
        if (biggestMa != null && biggestMa.length() > 2) {
            currentCode = Integer.parseInt(biggestMa.substring(2));
        }
        String newCode = "NV" + String.format("%02d", currentCode + 1);
        return newCode;
    }

    public Employee add(EmployeeRequest request){
        Employee employee = new Employee();
        employee.setCode(getNextCode());
        employee.setFullname(request.getFullname());
        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());
        employee.setImage(request.getImage());
        employee.setGender(request.getGender());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());
        employee.setEnabled(true);
        employee.setStatus(0);
        employee.setRole(Role.builder().id(request.getIdRole()).build());
        return repository.save(employee);
    }
    public Employee update(Integer id, EmployeeRequest request){
        Employee employee = repository.getById(id);
        employee.setFullname(request.getFullname());
        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());
        employee.setImage(request.getImage());
        employee.setGender(request.getGender());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());
        employee.setRole(Role.builder().id(request.getIdRole()).build());
        return repository.save(employee);
    }

    //cập nhật profile
    public Employee updateprofile(Integer idEmployee, CapNhatProfile form){
        Employee employee = repository.getById(idEmployee);
        employee.setFullname(form.getFullname());
        employee.setEmail(form.getEmail());
        employee.setPhone(form.getPhone());
        employee.setGender(form.getGender());
        employee.setImage(form.getImage());
        employee.setUpdateDate(new Date());
        return repository.save(employee);
    }

    // đổi mật khẩu
    public Employee change(Integer idEmployee, ChangeForm form){
        Employee employee = repository.getById(idEmployee);
        employee.setPassword(form.getRePasswordMoi());
        employee.setUpdateDate(new Date());
        return repository.save(employee);
    }

}
