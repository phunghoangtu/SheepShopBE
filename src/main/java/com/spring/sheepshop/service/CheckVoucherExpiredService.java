package com.spring.sheepshop.service;

import com.spring.sheepshop.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CheckVoucherExpiredService {
    @Autowired
    VoucherRepository repository;
    @Scheduled(cron = "0 * * * * *") // Chạy sau mỗi phút
    public void updateExpiredDiscounts() {
        System.out.println("Đã check voucher hết hạn");
        repository.updateExpensive();
    }
}
