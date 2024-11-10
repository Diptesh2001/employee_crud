package com.spring.mycompany.crud.controllers;

import com.spring.mycompany.crud.dao.EmployeeDao;
import com.spring.mycompany.crud.entity.Employee;
import com.spring.mycompany.crud.service.EmployeeService;
import com.spring.mycompany.crud.service.implementation.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService1){
        this.employeeService = employeeService1;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmps(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return employee;
    }

    @PostMapping("/employees/addEmployee")
    public Employee addEmployee(@RequestBody Employee newEmployee){

        newEmployee.setId(0);
        Employee dbEmployee = employeeService.save(newEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Delete employee id - " + employeeId;
    }
}
