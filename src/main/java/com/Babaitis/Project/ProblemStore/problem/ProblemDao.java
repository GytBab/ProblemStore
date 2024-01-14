package com.Babaitis.Project.ProblemStore.problem;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProblemDao {

    private List<Problem> problems = new ArrayList<>();

    public void save(Problem problem) {
        problem.setUuid(UUID.randomUUID());
        problems.add(problem);
    }

    public List<Problem> getAllProblems() {
        return problems;
    }
}
