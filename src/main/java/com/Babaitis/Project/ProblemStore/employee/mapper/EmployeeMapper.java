package com.Babaitis.Project.ProblemStore.employee.mapper;

import com.Babaitis.Project.ProblemStore.common.mapper.Mapper;
import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;
import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements Mapper<Employee, EmployeeDto> {

    public EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .employeeUuid(employee.getEmployeeUuid())
                .name(employee.getName())
                .surname(employee.getSurname())
                .email(employee.getEmail())
                .positionId(employee.getPositionId())
                .build();
    }


    public Employee fromDto(EmployeeDto employeeDto) {
        return Employee.builder()
                .employeeUuid(employeeDto.getEmployeeUuid())
                .name(employeeDto.getName())
                .surname(employeeDto.getSurname())
                .email(employeeDto.getEmail())
                .positionId(employeeDto.getPositionId())
                .build();
    }
}
