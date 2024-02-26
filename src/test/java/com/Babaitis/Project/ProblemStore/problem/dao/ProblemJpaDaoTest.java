package com.Babaitis.Project.ProblemStore.problem.dao;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import com.Babaitis.Project.ProblemStore.effect.Effect;
import com.Babaitis.Project.ProblemStore.laser.pojo.Laser;
import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProblemJpaDaoTest {

    @Test
    void save_FillsProblemWithUUIDAndCallsRepository() {
        var repository = mock(ProblemRepository.class);
        var problemDao = new ProblemJpaDao(repository);
        Problem problem = Problem.builder()
                .laser(new Laser())
                .effect(new Effect())
                .cause(new Cause())
                .solution("Some solution")
                .partNo("Part number")
                .entryDate("1212-12-12")
                .comment("No comment")
                .photos("Some URL to a photo folder")
                .build();

        problemDao.save(problem);

        assertNotNull(problem.getProblemUuid());

        verify(repository).save(any(Problem.class));
    }

    @Test
    void getByUUID_ReturnsAProductByUUID() {
        var repository = mock(ProblemRepository.class);
        var problemDao = new ProblemJpaDao(repository);
        var uuid = UUID.randomUUID();
        var product = Problem.builder().problemUuid(uuid).build();

        when(repository.findProblemByProblemUuid(uuid))
                .thenReturn(Optional.of(product));

        var actual = problemDao.getProblemByUuid(uuid);

        assertEquals(actual.get(), product);
    }

}
