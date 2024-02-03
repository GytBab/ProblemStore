package com.Babaitis.Project.ProblemStore.problem.mapper;

import com.Babaitis.Project.ProblemStore.common.mapper.Mapper;
import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import org.springframework.stereotype.Component;

@Component
public class ProblemMapper implements Mapper<Problem, ProblemDto> {

    public ProblemDto toDto(Problem problem) {
        return ProblemDto.builder()
                .problemUuid(problem.getProblemUuid())
                .laser(problem.getLaser())
                .effect(problem.getEffect())
                .cause(problem.getCause())
                .solution(problem.getSolution())
                .partNo(problem.getPartNo())
                .entryDate(problem.getEntryDate())
                .comment(problem.getComment())
                .photos(problem.getPhotos())
                .build();
    }

    public Problem fromDto(ProblemDto problemDto) {
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
