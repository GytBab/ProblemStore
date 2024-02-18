package com.Babaitis.Project.ProblemStore.employee.controller;

import com.Babaitis.Project.ProblemStore.employee.service.EmployeeRegistrationService;
import com.Babaitis.Project.ProblemStore.employee.service.EmployeeService;
import com.Babaitis.Project.ProblemStore.helper.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EmployeeController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeRegistrationService registrationService;
    @MockBean
    private EmployeeService employeeService;
    @MockBean
    private MessageService messageService;

    @Test
    void getEmployeeForm_shouldDisplayEmployeeForm() throws Exception {
        mockMvc.perform(get("/employee/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("employee/employee"))
                .andExpect(model().attributeExists("employeeDto"));
    }

}
