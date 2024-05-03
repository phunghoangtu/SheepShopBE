package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.Coupon;
import com.spring.sheepshop.repository.GetCouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCouponService {
    @Autowired
    private GetCouponRepo repo;

    public List<Coupon> getByCustomer(Integer id){
        return repo.getByCustomer(id);
    }
}
