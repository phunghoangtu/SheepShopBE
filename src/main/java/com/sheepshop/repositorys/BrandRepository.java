package com.sheepshop.repositorys;

import com.sheepshop.entitys.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    @Query(value = "Select e from Brand e where e.Status = 0 order by e.CreateDate desc ")
    List<Brand> getAll();
    @Query(value = "Select e from Brand e where e.Status = 0 and e.Name like :name")
    List<Brand> searchByName(@Param("name") String name);
    @Query(value = "select e from Brand e where e.Id = :id")
    Brand getById(@Param("id") Integer Id);
}