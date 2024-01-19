package com.Babaitis.Project.ProblemStore.problem.dao;

import com.Babaitis.Project.ProblemStore.problem.Problem;

import java.util.List;
import java.util.UUID;

public interface ProblemDao {
    void save(Problem problem);
    List<Problem> getAllProblems();
    Problem getProblemByUuid(UUID uuid);
    void update(Problem problem);
    void deleteByUuid(UUID uuid);


}
