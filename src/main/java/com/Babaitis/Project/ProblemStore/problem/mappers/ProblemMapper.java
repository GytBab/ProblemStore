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

    public Problem fromProblemDto(ProblemDto problemDto) {
        return Problem.builder()
                .problemUuid(problemDto.getProblemUuid())
                .laser(problemDto.getLaser())
                .effect(problemDto.getEffect())
                .cause((problemDto.getCause()))
                .solution(problemDto.getSolution())
                .partNo(problemDto.getPartNo())
                .entryDate(problemDto.getEntryDate())
                .comment(problemDto.getComment())
                .photos(problemDto.getPhotos())
                .build();
    }
}
