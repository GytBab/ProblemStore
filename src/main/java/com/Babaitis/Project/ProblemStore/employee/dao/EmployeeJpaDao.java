package com.Babaitis.Project.ProblemStore.employee.dao;

import com.Babaitis.Project.ProblemStore.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Primary
@Repository
public class EmployeeJpaDao implements EmployeeDao {

    EmployeeRepository repository;

    @Autowired
    public EmployeeJpaDao(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Employee employee) {
        employee.setEmployeeUuid(UUID.randomUUID());
        repository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        repository.save(employee);
    }
}
