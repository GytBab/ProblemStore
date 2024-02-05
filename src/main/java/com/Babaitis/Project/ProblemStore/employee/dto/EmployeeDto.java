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
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    private String email;
    private Position positionId;
}
