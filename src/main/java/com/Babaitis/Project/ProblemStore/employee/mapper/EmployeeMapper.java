package com.Babaitis.Project.ProblemStore.employee.mapper;

import com.Babaitis.Project.ProblemStore.common.mapper.Mapper;
import com.Babaitis.Project.ProblemStore.employee.pojo.Authority;
import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;
import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EmployeeMapper implements Mapper<Employee, EmployeeDto> {

    public EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .employeeUuid(employee.getEmployeeUuid())
                .name(employee.getName())
                .surname(employee.getSurname())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .positionId(employee.getPositionId())
                .build();
    }


    public Employee fromDto(EmployeeDto employeeDto) {
        return Employee.builder()
                .employeeUuid(employeeDto.getEmployeeUuid())
                .name(employeeDto.getName())
                .surname(employeeDto.getSurname())
                .email(employeeDto.getEmail())
                .password(new BCryptPasswordEncoder().encode(employeeDto.getPassword()))
                .positionId(employeeDto.getPositionId())
                .authorities(Set.of(
                        Authority.builder()
                                .name("USER")
                                .build()))
                .build();
    }
}
