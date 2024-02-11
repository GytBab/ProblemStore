package com.Babaitis.Project.ProblemStore.employee.service;

import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;
import com.Babaitis.Project.ProblemStore.employee.dao.EmployeeDao;
import com.Babaitis.Project.ProblemStore.employee.dao.EmployeeRepository;
import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import com.Babaitis.Project.ProblemStore.employee.mapper.EmployeeMapper;
import com.Babaitis.Project.ProblemStore.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


@Service
@Transactional
public class EmployeeService implements UserDetailsService {
    private final EmployeeMapper mapper;
    private final EmployeeDao employeeDao;
    private final PositionService positionService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao, EmployeeMapper mapper, PositionService positionService, EmployeeRepository employeeRepository) {
        this.employeeDao = employeeDao;
        this.mapper = mapper;
        this.positionService = positionService;
        this.employeeRepository = employeeRepository;
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findUserByEmailWithAuthorities(username)
                .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
    }
}
