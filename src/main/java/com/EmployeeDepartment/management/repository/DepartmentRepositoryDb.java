package com.EmployeeDepartment.management.repository;

import com.EmployeeDepartment.management.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositoryDb extends CrudRepository<Department, String> {
}
