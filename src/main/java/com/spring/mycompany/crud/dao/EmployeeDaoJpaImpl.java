package com.spring.mycompany.crud.dao;

import com.spring.mycompany.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager myEntityManager){
        this.entityManager = myEntityManager;

    }
    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee emp) {
        return entityManager.merge(emp);
    }

    @Override
    public void deleteById(int id) {
        Employee emp = entityManager.find(Employee.class,id);
        entityManager.remove(emp);
    }

    @Override
    public void deleteAll() {
        TypedQuery<Employee> query = entityManager.createQuery("delete * from Employee", Employee.class);
        query.executeUpdate();
    }
}
