package com.sheepshop.repositorys;

import com.sheepshop.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("Select e from Product  e where e.id = :id")
    Product getById(@Param("id") Integer id);

}
