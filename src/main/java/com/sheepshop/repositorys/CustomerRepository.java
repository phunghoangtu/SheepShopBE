package com.sheepshop.repositorys;

import com.sheepshop.entitys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    @Query(value = "select e from Customer e where e.username = :username")
    Customer getByUsername(@Param("username") String username);

}
