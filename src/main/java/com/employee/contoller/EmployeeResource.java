package com.employee.contoller;

import com.employee.dto.EmployeeDTO;
import com.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    public static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody EmployeeDTO employeeDTO, UriComponentsBuilder uriComponentsBuilder) {
        logger.info("Creating User: {}", employeeDTO);

       if(employeeService.isEmployeeExist(employeeDTO)) {
           logger.error("Unable to create. A user with name {} already exist",employeeDTO.getName());
           return new ResponseEntity<>(HttpStatus.CONFLICT);
       }
       employeeService.createEmployee(employeeDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/employees/create/{id}").buildAndExpand(employeeDTO.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDTO>> listAllEmployee(){
        List<EmployeeDTO> employeeDTOS = employeeService.getEmployee();
        if(employeeDTOS.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<EmployeeDTO>>(employeeDTOS,HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") long id){
        logger.info("Fetching User with id {}", id);
        EmployeeDTO employeeDTO = employeeService.findEmpId(id);
        if(employeeDTO == null){
            logger.error("Employee with id{} not found.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<EmployeeDTO>(employeeDTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@PathVariable("id") long id,@RequestBody EmployeeDTO employeeDTO){
        logger.info("Updating Employee with id {}", id);

        EmployeeDTO currentEmp = new EmployeeDTO();
         if(currentEmp == null){
             logger.error("Unable to update. User with id{} not found.", id);
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }
         currentEmp.setName(employeeDTO.getName());
         currentEmp.setId(employeeDTO.getId());
         currentEmp.setPhone(employeeDTO.getDepartment());
         currentEmp.setDepartment(employeeDTO.getDepartment());

         employeeService.modifyEmployee(currentEmp);
         return new ResponseEntity<>(currentEmp, HttpStatus.OK);
    }

    @RequestMapping(value= "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById (@PathVariable("id") long id){
        logger.info("Fetching & Deleting with id{}", id);

        EmployeeDTO  employeeDTO = employeeService.findEmpId(id);
        if(employeeDTO == null){
            logger.error("Unable to delete. User with id{} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/delete", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeDTO> deleteAllEmp(){
        logger.info("Deleting all users");

        employeeService.deleteAll();
        return new ResponseEntity<EmployeeDTO>(HttpStatus.NO_CONTENT);
    }
}