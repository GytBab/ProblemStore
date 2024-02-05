package com.Babaitis.Project.ProblemStore.employee.dao;

import com.Babaitis.Project.ProblemStore.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
