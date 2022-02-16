package com.EmployeeDepartment.management.controller;

import com.EmployeeDepartment.management.FileUploadHelper.FileUploadHelper;
import com.EmployeeDepartment.management.model.Department;
import com.EmployeeDepartment.management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    public FileUploadHelper fileUploadHelper;

    @RequestMapping(method = RequestMethod.POST,value="/department/")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }

    @RequestMapping("/department/getDepartments/")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/department/deleteDepartment/{id}")
    public Department deleteDepartment(@PathVariable String id){
         return departmentService.deleteDepartment(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/department/updateDepartment/")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @RequestMapping("/department/updateDataInDbUsingThreads")
    public void updateDataInDbUsingThreads(){
        departmentService.updateDataInDbUsingThreads();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/department/uploadFile")
    public void UploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getContentType());
        boolean f=fileUploadHelper.StoreFiles(multipartFile);
        System.out.println(f);
    }
}
