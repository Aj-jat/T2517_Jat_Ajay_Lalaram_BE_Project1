package com.EmployeeDepartment.management.service;
import com.EmployeeDepartment.management.model.Department;
import com.EmployeeDepartment.management.repository.DepartmentRepository;
import com.EmployeeDepartment.management.repository.DepartmentRepositoryDb;
import com.EmployeeDepartment.management.repository.EmployeeRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService implements DepartmentRepository{
    @Autowired
    private RedisTemplate<String ,Department> redisTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepositoryDb departmentRepositoryDb;

    public Department save(Department department){
        redisTemplate.opsForHash().put("Department",department.getDid(),department);
        return departmentRepositoryDb.save(department);
    }

    public List<Department> getDepartments(){
         System.out.println(redisTemplate.opsForHash().entries("Department"));
         return (List<Department>)departmentRepositoryDb.findAll();
    }

    @CacheEvict(value = "Department",allEntries = true)
    public Department deleteDepartment(String id){
        employeeRepository.deleteAllByDId(id);
        redisTemplate.opsForHash().delete("Department",id);
        Department department=departmentRepositoryDb.findById(id).get();
        departmentRepositoryDb.deleteById(id);
        return department;
    }

//Multipart File upload Service

    public void updateDataInDbUsingThreads(){
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            Department[] departmentList=objectMapper.readValue(new File("src/main/resources/static/:department.json"),Department[].class);
            departmentRepositoryDb.saveAll(Arrays.asList(departmentList));
        }
        catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Department updateDepartment(Department department){
        redisTemplate.opsForHash().put("Department",department.getDid(),department);
        return departmentRepositoryDb.save(department);
    }

}
