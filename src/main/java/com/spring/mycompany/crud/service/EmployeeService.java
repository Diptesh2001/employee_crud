package com.spring.mycompany.crud.service;

import com.spring.mycompany.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee emp);

    void deleteById(int id);

    void deleteAll();
}
