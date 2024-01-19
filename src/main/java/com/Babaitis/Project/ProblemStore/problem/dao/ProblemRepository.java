package com.Babaitis.Project.ProblemStore.problem.dao;

import com.Babaitis.Project.ProblemStore.problem.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

    Problem findProblemByProblemUuid(UUID uuid);
    void deleteByProblemUuid(UUID uuid);
}