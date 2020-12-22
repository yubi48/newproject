package com.employee;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeAppTests {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;


    @Test
    public void createEmployee(){
       /* EmployeeDTO employeeDTO = new EmployeeDTO(1,"Mark","2345676","IT");
        Assert.assertTrue(employeeService.createEmployee(employeeDTO));
        Optional<Employee> result = employeeRepo.findById((long)1);
        Assert.assertEquals(employeeDTO.getId(),result.get().getId());
        Assert.assertEquals(employeeDTO.getId(),result.get().getName());
        Assert.assertEquals(employeeDTO.getPhone(),result.get().getPhone());
        Assert.assertEquals(employeeDTO.getDepartment(),result.get().getDepartment());*/

    }

}
