package com.sheepshop.repositorys;

import com.sheepshop.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "Select p from Product p where p.status = 0")
    List<Product> getAllAPI();

    Product findByName(String name);


}
