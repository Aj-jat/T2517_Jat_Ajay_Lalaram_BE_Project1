package com.EmployeeDepartment.management.model;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Department implements Serializable {
    @Id
    private String did;
    private String dname;

    public Department() {
        super();
    }

    public Department(String did, String dname) {
        super();
        this.did = did;
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did='" + did + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
