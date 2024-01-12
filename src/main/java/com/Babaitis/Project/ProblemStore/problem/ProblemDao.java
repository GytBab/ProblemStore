package com.Babaitis.Project.ProblemStore.problem;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProblemDao {

    private List<Problem> problems = new ArrayList<>();

    public void save(Problem problem) {
        problems.add(problem);
    }

    public List<Problem> getAllProblems() {
        return problems;
    }
}
