package com.EmployeeDepartment.management.repository;

import com.EmployeeDepartment.management.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String > {

    public void deleteById(String id);

    @Query("SELECT employee from Employee employee WHERE employee.did=:id")
    public List<Employee> findByDid(@PathVariable String id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee employee WHERE employee.did=:id")
    void deleteAllByDId(@PathVariable String id);
}
