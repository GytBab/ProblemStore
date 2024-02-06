package com.Babaitis.Project.ProblemStore.validation;

import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<RepeatPassword, EmployeeDto> {

    @Override
    public boolean isValid(EmployeeDto employeeDto, ConstraintValidatorContext context) {
        return employeeDto.getPassword().equals(employeeDto.getRepeatPassword());
    }
}
