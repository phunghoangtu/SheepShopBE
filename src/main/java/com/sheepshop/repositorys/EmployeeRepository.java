package com.sheepshop.repositorys;
import com.sheepshop.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "Select e from Employee e where e.Status = 0")
    List<Employee> getAll();

    @Query(value = "Select e from Employee e where e.Status = 1")
    List<Employee> getAll1();

    @Query(value = "Select e from Employee e where e.Fullname like :fullname")
    List<Employee> searchByName(@Param("fullname") String fullname);

    @Query(value = "select e from Employee e where e.Id = :id")
    Employee getById(@Param("id") Integer Id);

    @Query(value = "select e from Employee e where e.Username = :username")
    Employee getByUsername(@Param("username") String username);

    @Query(value = "select e from Employee e where e.Status = 0 and (e.role.Id = :idRole or :idRole is null)")
    List<Employee> getEmployeeByRole(@Param("idRole") Integer id);

    @Query(value = "Select e from Employee e where e.Status = :status")
    List<Employee> getByStatus(@Param("status") Integer status);

}
