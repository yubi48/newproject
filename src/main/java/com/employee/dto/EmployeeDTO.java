package com.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private long Id;
    private String name;
    private String phone;
    private String department;

    public EmployeeDTO(){

    }

    public EmployeeDTO(long Id, String name, String phone, String department) {
    this.Id= Id;
    this.name = name;
    this.phone = phone;
    this.department= department;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
