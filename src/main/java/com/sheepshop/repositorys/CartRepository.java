package com.sheepshop.repositorys;


import com.sheepshop.entitys.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query(value = "Select e from Cart  e where e.Id = :id")
     Cart getByIdCart(@Param("id") Integer id);
    @Query(value = "Select e from Cart  e where e.customer.Id = :id")
     Cart getByIdCustomer(@Param("id") Integer id);
}
