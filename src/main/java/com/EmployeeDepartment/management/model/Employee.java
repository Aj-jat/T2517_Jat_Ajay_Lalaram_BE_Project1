package com.EmployeeDepartment.management.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private String did;
    @ManyToOne
    @JoinColumn(name = "DeptId",referencedColumnName = "did")
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }

    public Employee() {
        super();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Employee(String id, String name, Department department) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
