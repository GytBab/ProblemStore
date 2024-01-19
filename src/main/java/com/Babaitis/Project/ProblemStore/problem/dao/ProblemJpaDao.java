package com.Babaitis.Project.ProblemStore.problem.dao;

import com.Babaitis.Project.ProblemStore.problem.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class ProblemJpaDao implements ProblemDao {

    ProblemRepository repository;

    @Autowired
    public ProblemJpaDao(ProblemRepository problemRepository) {
        this.repository = problemRepository;
    }

    @Override
    public void save(Problem problem) {
        problem.setProblemUuid(UUID.randomUUID());
        repository.save(problem);
    }

    @Override
    public List<Problem> getAllProblems() {
        return repository.findAll();
    }

    @Override
    public Problem getProblemByUuid(UUID uuid) {
        return repository.findProblemByProblemUuid(uuid);
    }

    @Override
    public void update(Problem problem) {
        repository.save(problem);
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        repository.deleteByProblemUuid(uuid);
    }
}
