package com.sheepshop.repositorys;

import com.sheepshop.entitys.ProductdetailMaterial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetail_MaterialRepository extends JpaRepository<ProductdetailMaterial,Integer> {

    @Query(value = "Select e from ProductdetailMaterial  e where  e.productDetail.Id =:id")
    List<ProductdetailMaterial> getAllById(@Param("id") Integer id);

}
