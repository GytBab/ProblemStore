package com.Babaitis.Project.ProblemStore.employee.dao;

import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJpaDaoTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private EmployeeRepository repository;

    @Test
    void save_savesAnEmployee() {
        var employeeDao = new EmployeeJpaDao(repository);
        Employee employee = employeeDao.repository.findAll().get(1);

        employeeDao.save(employee);

        var id = testEntityManager.getId(employee, Long.class);
        assertTrue(id > 0);
        var savedEmployee = testEntityManager.find(Employee.class, id);

        assertEquals(savedEmployee.getName(), employee.getName());
        assertEquals(savedEmployee.getSurname(), employee.getSurname());
        assertEquals(savedEmployee.getEmail(), employee.getEmail());
        assertEquals(savedEmployee.getPassword(), employee.getPassword());
        assertEquals(savedEmployee.getPositionId(), employee.getPositionId());
        assertNotNull(savedEmployee.getEmployeeUuid());
    }

    @Test
    void updateProblem_UpdatesAProblem() {
        var employeeDao = new EmployeeJpaDao(repository);
        Employee employeeToUpdate = employeeDao.repository.findAll().get(1);

        String newName = "new name";
        String newSurname = "new surname";
        String newPassword = "new password";
        String newEmail = "new@email.com";

        employeeToUpdate.setName(newName);
        employeeToUpdate.setSurname(newSurname);
        employeeToUpdate.setPassword(newPassword);
        employeeToUpdate.setEmail(newEmail);
        employeeDao.update(employeeToUpdate);

        var id = testEntityManager.persistAndGetId(employeeToUpdate, Long.class);
        var updatedEmployee = testEntityManager.find(Employee.class, id);

        assertEquals(updatedEmployee.getName(), employeeToUpdate.getName());
        assertEquals(updatedEmployee.getSurname(), employeeToUpdate.getSurname());
        assertEquals(updatedEmployee.getPassword(), employeeToUpdate.getPassword());
        assertEquals(updatedEmployee.getEmail(), employeeToUpdate.getEmail());

    }
}
