package com.Babaitis.Project.ProblemStore.employee.service;

import com.Babaitis.Project.ProblemStore.employee.dao.EmployeeRepository;
import com.Babaitis.Project.ProblemStore.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class EmployeeService implements UserDetailsService {
    private final PositionService positionService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(PositionService positionService, EmployeeRepository employeeRepository) {
        this.positionService = positionService;
        this.employeeRepository = employeeRepository;
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
