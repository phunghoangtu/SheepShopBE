package com.sheepshop.repositorys;

import com.sheepshop.entitys.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size,Integer> {
    @Query(value = "Select e from Size e where e.Status = 0 order by e.CreateDate desc ")
    List<Size> getAll();
    @Query(value = "Select e from Size e where e.Status = 0 and e.Name like :name")
    List<Size> searchByName(@Param("name") String name);
    @Query(value = "select e from Size e where e.Id = :id")
    Size getById(@Param("id") Integer Id);
}
