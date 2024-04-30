package com.sheepshop.services;


import com.sheepshop.entitys.Bill;
import com.sheepshop.entitys.Employee;
import com.sheepshop.model.req.BillTaiQuayRequest;
import com.sheepshop.model.resp.BillResponse;
import com.sheepshop.repositorys.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<BillResponse> getAllByStatus(Integer status){
        return billRepository.getBillByStatus(status);
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

    public Bill addBillTaiQuay(BillTaiQuayRequest request){
        Bill bill = new Bill();
        bill.setCode(getNextCode());
        bill.setPayStatus(request.getPayStatus());
        bill.setStatus(request.getStatus());
        bill.setEmployee(Employee.builder().id(request.getEmployee()).build());
        return billRepository.save(bill);
    }




}
