package com.Babaitis.Project.ProblemStore.problem.mappers;

import com.Babaitis.Project.ProblemStore.problem.Problem;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import org.springframework.stereotype.Component;

@Component
public class ProblemMapper {

    public ProblemDto toProblemDto(Problem problem) {
        return new ProblemDto(
                problem.getProblemUuid(),
                problem.getLaser(),
                problem.getEffect(),
                problem.getCause(),
                problem.getSolution(),
                problem.getPartNo(),
                problem.getEntryDate(),
                problem.getComment(),
                problem.getPhotos());
    }


}
