package com.Babaitis.Project.ProblemStore.employee.controller;

import com.Babaitis.Project.ProblemStore.HttpEndPoints;
import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import com.Babaitis.Project.ProblemStore.employee.service.EmployeeRegistrationService;
import com.Babaitis.Project.ProblemStore.employee.service.EmployeeService;
import com.Babaitis.Project.ProblemStore.helper.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final MessageService messageService;
    private final EmployeeService employeeService;
    private final EmployeeRegistrationService employeeRegistrationService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndPoints.EMPLOYEE_CREATE)
    public String getEmployeeForm(Model model, String message) {
        model.addAttribute("employeeDto", EmployeeDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));
        employeeService.getChoiceForPosition(model);
        return "employee/employee";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(HttpEndPoints.EMPLOYEE_CREATE)
    public String register(Model model, @Valid EmployeeDto employeeDto, BindingResult errors) {
        if (errors.hasErrors()) {
            employeeService.getChoiceForPosition(model);
            return "employee/employee";
        }
        try {
        employeeRegistrationService.registerEmployee(employeeDto);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("EMAIL")) {
                //TODO: pasiaskinti kodel nerodo klaidos html'e
                errors.rejectValue("email", "Email already used!");
            }
        }

        return "redirect:/employee/create?message=employee.create.messages.success";
    }


}
