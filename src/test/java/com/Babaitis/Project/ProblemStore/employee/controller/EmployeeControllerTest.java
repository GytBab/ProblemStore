package com.Babaitis.Project.ProblemStore.employee.controller;

import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import com.Babaitis.Project.ProblemStore.employee.service.EmployeeRegistrationService;
import com.Babaitis.Project.ProblemStore.employee.service.EmployeeService;
import com.Babaitis.Project.ProblemStore.helper.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeRegistrationService registrationService;
    @Mock
    private EmployeeService employeeService;
    @Mock
    private MessageService messageService;
    @Mock
    private Model model;
    @InjectMocks
    private EmployeeController employeeController;
    @Mock
    private BindingResult bindingResult;

    @Test
    void getEmployeeForm_returnsTheEmployeeFormTemplate() {
        String message = "Some message";
        var template = employeeController.getEmployeeForm(model, message);

        assertEquals("employee/employee", template);
        verify(model).addAttribute(eq("employeeDto"), any(EmployeeDto.class));
    }

    @Test
    void register_callsServiceMethodsToRegisterEmployee() {
        var employeeDto = EmployeeDto.builder().build();

        when(bindingResult.hasErrors()).thenReturn(false);

        var template = employeeController.register(model, employeeDto, bindingResult);

        assertEquals("redirect:/employee/create?message=employee.create.messages.success", template);
        verify(registrationService).registerEmployee(employeeDto);
    }

    @Test
    void register_getAnError_RedirectsBackToEmployeeForm() {
        var employeeDto = EmployeeDto.builder().build();

        when(bindingResult.hasErrors()).thenReturn(true);

        var template = employeeController.register(model, employeeDto, bindingResult);

        assertEquals("employee/employee", template);
        verifyNoInteractions(registrationService);
    }
}
