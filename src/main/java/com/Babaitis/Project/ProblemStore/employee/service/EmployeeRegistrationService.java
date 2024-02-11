package com.Babaitis.Project.ProblemStore.employee.service;

import com.Babaitis.Project.ProblemStore.employee.dao.AuthorityRepository;
import com.Babaitis.Project.ProblemStore.employee.dao.EmployeeDao;
import com.Babaitis.Project.ProblemStore.employee.dto.EmployeeDto;
import com.Babaitis.Project.ProblemStore.employee.pojo.Authority;
import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeRegistrationService {

    private final AuthorityRepository authorityRepository;
    private final EmployeeDao employeeDao;

    @Transactional
    public void registerEmployee(EmployeeDto employeeDto) throws DataIntegrityViolationException {
        final Set<Authority> authorities = authorityRepository.findAll().stream()
                .filter(authority -> authority.getName().equals("USER"))
                .collect(Collectors.toSet());

        employeeDao.save(Employee.builder()
                .employeeUuid(employeeDto.getEmployeeUuid())
                .name(employeeDto.getName())
                .surname(employeeDto.getSurname())
                .email(employeeDto.getEmail())
                .password(new BCryptPasswordEncoder().encode(employeeDto.getPassword()))
                .positionId(employeeDto.getPositionId())
                .authorities(authorities)
                .build());
    }
}
