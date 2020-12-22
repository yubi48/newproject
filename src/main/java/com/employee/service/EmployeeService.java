package com.employee.service;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getEmployee();

    void modifyEmployee(EmployeeDTO employeeDTO);

    void remove(Long id);

    public EmployeeDTO findEmpId(long id);

    boolean isEmployeeExist(EmployeeDTO employeeDTO);

    void deleteAll();
}
