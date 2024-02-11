package com.Babaitis.Project.ProblemStore.employee.dao;

import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;

public interface EmployeeDao {

    void save(Employee employee);
    void update(Employee employee);
}
