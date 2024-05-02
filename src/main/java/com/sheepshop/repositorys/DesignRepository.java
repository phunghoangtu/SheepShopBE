package com.sheepshop.repositorys;

import com.sheepshop.entitys.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignRepository extends JpaRepository<Design,Integer> {
    @Query(value = "Select e from Design e where e.Status = 0 order by e.CreateDate desc ")
    List<Design> getAll();
    @Query(value = "Select e from Design e where e.Status = 0 and e.Name like :name")
    List<Design> searchByName(@Param("name") String name);
    @Query(value = "select e from Design e where e.Id = :id")
    Design getById(@Param("id") Integer Id);
}

