package com.sheepshop.repositorys;

import com.sheepshop.entitys.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Integer> {

    @Query(value = "Select e from Material e where e.Status = 0 order by e.CreateDate desc ")
    List<Material> getAll();
    @Query(value = "Select e from Material e where e.Status = 0 and e.Name like :name")
    List<Material> searchByName(@Param("name") String name);
    @Query(value = "select e from Material e where e.Id = :id")
    Material getById(@Param("id") Integer Id);

}
