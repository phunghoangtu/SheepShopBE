package com.sheepshop.services;


import com.sheepshop.entitys.Bill;
import com.sheepshop.entitys.Customer;
import com.sheepshop.entitys.User;
import com.sheepshop.repositorys.BillRepository;
import com.sheepshop.repositorys.CustomerRepository;
import com.sheepshop.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {


    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Bill> getBillChuaThanhToan() {
        return billRepository.getBillChuaThanhToan();
    }

    private String getNextCode() {
        int currentCode = Integer.parseInt(billRepository.getBiggestMa().substring(2));
        String newCode = "HD" + ++currentCode;
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
