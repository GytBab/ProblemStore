package com.Babaitis.Project.ProblemStore.problem.service;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import com.Babaitis.Project.ProblemStore.effect.Effect;
import com.Babaitis.Project.ProblemStore.laser.Laser;
import com.Babaitis.Project.ProblemStore.problem.dao.ProblemDao;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import com.Babaitis.Project.ProblemStore.problem.mapper.ProblemMapper;
import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProblemServiceTest {

    @Mock
    private ProblemDao problemDao;

    @Mock ProblemMapper mapper;

    @InjectMocks
    private ProblemService service;

    @Test
    public void saveProduct_savesAProductAndSetsCategory() {

        UUID problemUuid = UUID.randomUUID();
        Laser laser = new Laser();
        Effect effect = new Effect();
        Cause cause = new Cause();
        Problem problem = new Problem();

        ProblemDto problemDto = new ProblemDto(
                problemUuid,
                laser,
                effect,
                cause,
                "Cleaning the power supply unit",
                "PS5062",
                "2021-02-03",
                "No comment",
                "Some URL to photo folder");

        when(mapper.fromDto(problemDto)).thenReturn(problem);

        service.saveProblem(problemDto);

        verify(mapper).fromDto(eq(problemDto));
        verify(problemDao).save(eq(problem));
    }

}
