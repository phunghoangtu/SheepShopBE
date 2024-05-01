package com.sheepshop.repositorys;

import com.sheepshop.entitys.ProductDetail;
import com.sheepshop.entitys.Voucher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {
    @Query(value = "Select e from ProductDetail e where e.id = :id")
    ProductDetail getById(@Param("id") Integer id);
    @Query(value = "Select e from ProductDetail e where e.status = 0 Order by e.createDate desc")
    List<ProductDetail> getAll();
    @Query(value = "Select e from ProductDetail e where e.status = 1 Order by e.createDate desc")
    List<ProductDetail> getAll1();
    List<ProductDetail> getAllByProductName(@Param("name") String name);


}
