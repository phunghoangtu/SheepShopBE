package com.sheepshop.repositorys;

import com.sheepshop.entitys.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart , Integer>{

}
