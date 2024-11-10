package com.spring.mycompany.crud.dao;

import com.spring.mycompany.crud.entity.Employee;
import com.spring.mycompany.crud.service.EmployeeService;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee emp);

    void deleteById(int id);

    void deleteAll();
}
