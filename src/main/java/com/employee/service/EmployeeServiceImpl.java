package com.employee.service;

import com.employee.DTO.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee emp = new Employee(employeeDTO.getId(),employeeDTO.getName(),employeeDTO.getPhone(),employeeDTO.getDepartment());
        employeeRepo.save(emp);

    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public void modifyEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> record = employeeRepo.findById(employeeDTO.getId());
        Employee newRecord = new Employee();
        newRecord.setId(employeeDTO.getId());

        if (employeeDTO.getName() != null){
            newRecord.setName(employeeDTO.getName());
        }

        if(employeeDTO.getPhone() != null){
            newRecord.setPhone(employeeDTO.getPhone());
        }

        if(employeeDTO.getDepartment() != null){
            newRecord.setDepartment(employeeDTO.getDepartment());
        }
    }

    @Override
    public void remove(Long id) {
        employeeRepo.deleteById(id);
    }


}

