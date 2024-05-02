package com.sheepshop.repositorys;


import com.sheepshop.entitys.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query(value = "Select e from Role e where e.Status = 0")
    List<Role> getAll();
    @Query(value = "Select e from Role e where e.Status = 0 and e.Name like :name")
    List<Role> searchByName(@Param("name") String name);
    @Query(value = "select e from Role e where e.Id = :id")
    Role getById(@Param("id") Integer Id);

}
