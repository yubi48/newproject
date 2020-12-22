package com.employee.service;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

   // private static List<Employee> employees;


    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee emp = new Employee(employeeDTO.getId(),employeeDTO.getName(),employeeDTO.getPhone(),employeeDTO.getDepartment());
        employeeRepo.save(emp);
    }

    private List<EmployeeDTO> convertEntityIntoDto(List<Employee> employeeList){
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee employee : employeeList){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee,employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public List<EmployeeDTO> getEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return convertEntityIntoDto(employees);
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

    @Override
    public boolean isEmployeeExist(EmployeeDTO employeeDTO) {
        return findByName(employeeDTO.getName())!=null;
    }

    @Override
    public void deleteAll() {
        employeeRepo.deleteAll();
    }

    @Override
    public EmployeeDTO findEmpId(long id){
        Employee employee = findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);
        return  employeeDTO;
    }


    private Employee findByName(String name) {
        List<Employee> employees = employeeRepo.findAll();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    private Employee findById(long id){
        List<Employee> employees = employeeRepo.findAll();
        for(Employee employee : employees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }



}

