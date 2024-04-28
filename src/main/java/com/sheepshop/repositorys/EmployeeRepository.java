package com.sheepshop.repositorys;

import com.sheepshop.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "Select e from Employee e where e.status = 0")
    public List<Employee> getAll();

    @Query(value = "Select e from Employee e where e.fullname like :fullname")
    public List<Employee> searchByName(@Param("fullname") String fullname);

    @Query(value = "select e from Employee e where e.id = :id")
    public Employee getById(@Param("id") Long Id);

    @Query(value = "select e from Employee e where e.username = :username")
    public Employee getByUsername(@Param("username") String username);

    @Query(value = "select e from Employee e where e.status = 0 and (e.role.id = :idRole or :idRole is null)")
    public List<Employee> getEmployeeByRole(@Param("idRole") Long id);

    @Query(value = "Select e from Employee e where e.status = :status")
    public List<Employee> getByStatus(@Param("status") Integer status);


}
