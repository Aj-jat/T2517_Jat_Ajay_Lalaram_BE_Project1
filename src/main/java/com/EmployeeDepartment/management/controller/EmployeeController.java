package com.EmployeeDepartment.management.controller;
import com.EmployeeDepartment.management.FileUploadHelper.EmployeeUploadHelper;
import com.EmployeeDepartment.management.model.Employee;
import com.EmployeeDepartment.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    public EmployeeUploadHelper employeeUploadHelper;

    @RequestMapping(method = RequestMethod.POST,value = "/employee/")
    public Employee addEmployee(@RequestBody Employee employee){
         return employeeService.addEmployee(employee);
    }

    @RequestMapping("/employee/findEmployeeById/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable String id){
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping("/employee/findEmployeeByDid/{id}")
    public List<Employee> findEmployeeByDid(@PathVariable String id){
        return employeeService.findEmployeeByDid(id);
    }

    @RequestMapping("/employee/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/employee/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable String id){
        return employeeService.updateEmployee(employee,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/employee/delete/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(value="/employee/updateDataInDbUsingThreads")
    public void updateDataInDbUsingThreads(){
        employeeService.updateDataInDbUsingThreads();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/employee/uploadFile")
    public void UploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getContentType());
        boolean f=employeeUploadHelper.StoreFiles(multipartFile);
        System.out.println(f);
    }
}
