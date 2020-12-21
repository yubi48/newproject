package com.employee.DTO;

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
    }
}
