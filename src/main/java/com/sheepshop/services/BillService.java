package com.sheepshop.services;


import com.sheepshop.entitys.Bill;
import com.sheepshop.entitys.Employee;
import com.sheepshop.model.req.BillTaiQuayRequest;
import com.sheepshop.model.resp.*;
import com.sheepshop.repositorys.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        int currentCode = 0;
        if (biggestMa != null && biggestMa.length() > 2) {
            currentCode = Integer.parseInt(biggestMa.substring(2));
        }
        String newCode = "HD" + String.format("%02d", currentCode + 1);
        return newCode;
    }

    public Bill addBillTaiQuay(BillTaiQuayRequest request){
        Bill bill = new Bill();
        bill.setCode(getNextCode());
        bill.setPurchaseDate(new Date());
        bill.setTypeStatus(request.getTypeStatus());
        bill.setStatus(request.getStatus());
        bill.setEmployee(Employee.builder().id(request.getIdEmployee()).build());
        return billRepository.save(bill);
    }

    public TKNgay getTKNgay(){
        return billRepository.getThongKeNgay();
    }
    public TKThang getTKThang(){
        return billRepository.getThongKeThang();
    }
    public TKSLThang getTKSLThang(){
        return billRepository.getThongKeSoLuongThang();
    }
    public List<TKSoLuongHD> getTKSoLuongHD(String tungay, String denngay){
        return billRepository.getTKSoLuongHD(tungay,denngay);
    }
    public List<TKSoLuongSanPham> getTKSoLuongSanPham(String tungay, String denngay){
        return billRepository.getTKSoLuongSanPham(tungay,denngay);
    }
    public List<TKHoaDonStatus> getTKSoLuongHDStatus(String tungay, String denngay){
        return billRepository.getTKSoLuongHDStatus(tungay,denngay);
    }


}
