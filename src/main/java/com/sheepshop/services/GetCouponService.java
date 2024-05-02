package com.sheepshop.services;

import com.sheepshop.entitys.Coupon;
import com.sheepshop.repositorys.GetCouponRepo;
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
