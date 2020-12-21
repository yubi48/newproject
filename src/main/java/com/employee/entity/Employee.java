package com.employee.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="employee_tbl")
public class Employee {
    @Id
    private long id;
    private String name;
    private String phone;
    private String department;


    public Employee(long id, String name, String phone, String department) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.department = department;
    }

    public Employee() {

    }
}
