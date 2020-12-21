package com.employee.service;

import com.employee.DTO.EmployeeDTO;
import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeDTO employeeDTO);

    List<Employee> getEmployee();

    void modifyEmployee(EmployeeDTO employeeDTO);

    void remove(Long id);
}
