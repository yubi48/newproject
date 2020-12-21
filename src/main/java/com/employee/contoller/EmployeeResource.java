package com.employee.contoller;

import com.employee.DTO.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void create(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);

    }

    @GetMapping("/employee")
    public List<Employee> findEmployee(){
        return employeeService.getEmployee();

    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.modifyEmployee(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable Long id){
        employeeService.remove(id);
    }
}