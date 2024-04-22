package com.sheepshop.repositorys;

import com.sheepshop.entitys.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<Bill , Integer> {


}
