package com.Babaitis.Project.ProblemStore.employee.service;

import com.Babaitis.Project.ProblemStore.employee.Employee;
import com.Babaitis.Project.ProblemStore.employee.dao.EmployeeDao;
import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import com.Babaitis.Project.ProblemStore.employee.mapper.EmployeeMapper;
import com.Babaitis.Project.ProblemStore.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


@Service
@Transactional
public class EmployeeService {
    private final EmployeeMapper mapper;
    private final EmployeeDao employeeDao;
    private final PositionService positionService;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao, EmployeeMapper mapper, PositionService positionService) {
        this.employeeDao = employeeDao;
        this.mapper = mapper;
        this.positionService = positionService;
    }

    // CRUD operations:
    // Create
    @Transactional
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.fromDto(employeeDto);
        employeeDao.save(employee);
    }

    public void getChoiceForPosition(Model model) {
        model.addAttribute("positions", positionService.getAllPositions());
    }
}
