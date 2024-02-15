package com.Babaitis.Project.ProblemStore.problem.dao;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import com.Babaitis.Project.ProblemStore.effect.Effect;
import com.Babaitis.Project.ProblemStore.laser.Laser;
import com.Babaitis.Project.ProblemStore.laser_data.Laser_data;
import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProblemJpaDaoIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private ProblemRepository repository;

    @Test
    void save_persistsAGivenProduct() {
        //Pull out some problem from Database
        var problemDao = new ProblemJpaDao(repository);
        Problem problem = problemDao.getAllProblems().get(1);

        //Check save method
        problemDao.save(problem);

        //Check if saved problem is the save as taken from database
        var id = testEntityManager.getId(problem, Long.class);
        assertTrue(id > 0);
        var savedProblem = testEntityManager.find(Problem.class, id);

        assertEquals(savedProblem.getSolution(), problem.getSolution());
        assertEquals(savedProblem.getPartNo(), problem.getPartNo());
        assertEquals(savedProblem.getEntryDate(), problem.getEntryDate());
        assertEquals(savedProblem.getComment(), problem.getComment());
        assertEquals(savedProblem.getPhotos(), problem.getPhotos());
        assertNotNull(savedProblem.getProblemUuid());
    }

    @Test
    void getProblemByUuid_returnsAProblemByUuid() {
        UUID problemUuid = UUID.fromString("910879c5-caa6-421b-81a7-9edf9e20207d");
        var problemDao = new ProblemJpaDao(repository);

        Problem problem = problemDao.getProblemByUuid(problemUuid).get();
        Long problemId = problem.getId();


        Long id = testEntityManager.getId(problem, Long.class);
        assertEquals(problemId, id);

        testEntityManager.persistAndFlush(problem);
        Problem savedProblem = problemDao.getProblemByUuid(problemUuid).get();

        assertEquals(savedProblem.getLaser(), problem.getLaser());
        assertEquals(savedProblem.getEffect(), problem.getEffect());
        assertEquals(savedProblem.getCause(), problem.getCause());
        assertEquals(savedProblem.getSolution(), problem.getSolution());
        assertEquals(savedProblem.getPartNo(), problem.getPartNo());
        assertEquals(savedProblem.getEntryDate(), problem.getEntryDate());
        assertEquals(savedProblem.getComment(), problem.getComment());
        assertEquals(savedProblem.getPhotos(), problem.getPhotos());
        assertTrue(savedProblem.getId() > 0);
    }
}
