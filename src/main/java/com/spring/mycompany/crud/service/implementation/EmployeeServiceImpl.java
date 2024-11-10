package com.spring.mycompany.crud.service.implementation;

import com.spring.mycompany.crud.dao.EmployeeDaoJpaImpl;
import com.spring.mycompany.crud.entity.Employee;
import com.spring.mycompany.crud.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDaoJpaImpl employeeDaoJpa;

    @Autowired
    public EmployeeServiceImpl(EmployeeDaoJpaImpl employeeDaoJpa1){
        this.employeeDaoJpa = employeeDaoJpa1;
    }
    @Override
    public List<Employee> findAll(){
        return employeeDaoJpa.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDaoJpa.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee emp) {
        return employeeDaoJpa.save(emp);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDaoJpa.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        employeeDaoJpa.deleteAll();
    }
}
