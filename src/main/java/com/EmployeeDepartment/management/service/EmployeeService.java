package com.EmployeeDepartment.management.service;

import com.EmployeeDepartment.management.model.Department;
import com.EmployeeDepartment.management.model.Employee;
import com.EmployeeDepartment.management.repository.EmployeeRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class EmployeeService {

    private Integer i=-10;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setDepartment(new Department(employee.getDid(),""));
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        List<Employee> employeeList=new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    public Employee updateEmployee(Employee employee,String id){
        employee.setDepartment(new Department(employee.getDid(),""));
        return employeeRepository.save(employee);
    }

    public void updateDataInDbUsingThreads(){
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            Employee[] employeeList=objectMapper.readValue(new File("src/main/resources/static/:employee.json"),Employee[].class);

            ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(10);

            for(int j=0;j<10;j++){
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        List<Employee> arr=Arrays.asList(employeeList).subList(i,i+10);
                        System.out.println(i+","+arr.get(0));
                        employeeRepository.saveAll(arr);
                    }
                });
                i=i+10;
                System.out.println(i);
            }
            executor.shutdown();
        }
        catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(String id){
        EmployeeService employeeService;
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> findEmployeeById(String id){
        return employeeRepository.findById(id);
    }

    public List<Employee> findEmployeeByDid(String id){
        return employeeRepository.findByDid(id);
    }
}
