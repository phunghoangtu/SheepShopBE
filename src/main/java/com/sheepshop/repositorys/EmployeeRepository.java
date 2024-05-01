package com.sheepshop.repositorys;


import com.sheepshop.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select code from employee e order by len(e.code) desc, e.code desc offset 0 row fetch next 1 row only", nativeQuery = true)
    String getBiggestMa();

    @Query(value = "Select e from Employee e where e.status = 0")
    List<Employee> getAll();

    @Query(value = "Select e from Employee e where e.fullname like :fullname")
    List<Employee> searchByName(@Param("fullname") String fullname);

    @Query(value = "select e from Employee e where e.id = :id")
    Employee getById(@Param("id") Integer id);

    @Query(value = "select e from Employee e where e.username = :username")
    Employee getByUsername(@Param("username") String username);

    @Query(value = "select e from Employee e where e.status = 0 and (e.role.id = :idRole or :idRole is null)")
    List<Employee> getEmployeeByRole(@Param("idRole") Integer idRole);




}
