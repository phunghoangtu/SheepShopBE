package com.sheepshop.services;


import com.sheepshop.entitys.Bill;
import com.sheepshop.repositorys.BillRepository;
import com.sheepshop.repositorys.CustomerRepository;
import com.sheepshop.repositorys.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {


    @Autowired
    private BillRepository billRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Bill> getBillChuaThanhToan() {
        return billRepository.getBillChuaThanhToan();
    }

    private String getNextCode() {
        String biggestMa = billRepository.getBiggestMa();
        int currentCode = 1;
        if (biggestMa != null && biggestMa.length() > 2) {
            currentCode = Integer.parseInt(biggestMa.substring(2));
        }
        String newCode = "HD" + String.format("%02d", currentCode + 1);
        return newCode;
    }

    public Bill addBill(Bill bill) {
        bill.setCode(getNextCode());
        return billRepository.save(bill);
    }

    public Bill deleteBillById(Long id) {
        Optional<Bill> billOptional = billRepository.findById(id);
        return billOptional.map(o-> {
            billRepository.delete(o);
            return o;
        }).orElse(null);
    }



}
