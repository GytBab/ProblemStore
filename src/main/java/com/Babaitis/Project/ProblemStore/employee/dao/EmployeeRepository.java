package com.Babaitis.Project.ProblemStore.employee.dao;

import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value =
            "SELECT e FROM Employee e" +
                    " JOIN FETCH e.authorities" +
                    " WHERE e.email = :email")
    Optional<Employee> findUserByEmailWithAuthorities(String email);
}
