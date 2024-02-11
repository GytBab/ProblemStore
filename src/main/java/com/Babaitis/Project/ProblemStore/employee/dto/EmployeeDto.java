package com.Babaitis.Project.ProblemStore.employee.dto;

import com.Babaitis.Project.ProblemStore.position.Position;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private UUID employeeUuid;
    @NotBlank (message = "{employee.name.notBlank}")
    private String name;
    @NotBlank(message = "{employee.surname.notBlank}")
    private String surname;
    @NotBlank(message = "{employee.password.notBlank}")
    private String password;
    @NotBlank(message = "{employee.password.notBlank}")
    private String repeatPassword;
    @NotBlank (message = "{employee.email.notBlank}")
    @Email (message = "{employee.email.wrong}")
    private String email;
    private Position positionId;
}
