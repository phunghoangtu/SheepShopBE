package com.sheepshop.repositorys;

import com.sheepshop.entitys.ProductVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVoucherRepository extends JpaRepository<ProductVoucher,Integer> {
    @Query("select e from ProductVoucher e where e.product.id = :id")
    List<ProductVoucher> getByProduct(@Param("id") Integer id);

}
