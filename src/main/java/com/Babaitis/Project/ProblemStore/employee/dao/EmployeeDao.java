package com.Babaitis.Project.ProblemStore.employee.dao;

import com.Babaitis.Project.ProblemStore.employee.Employee;

public interface EmployeeDao {

    void save(Employee employee);
    void update(Employee employee);
}
