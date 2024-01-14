package com.Babaitis.Project.ProblemStore.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProblemService {

    private ProblemDao problemDao;

    @Autowired
    public ProblemService(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }

    // CRUD operations:
    // Create
    public void saveProblem(Problem problem) {
        problemDao.save(problem);
    }

    // Read
    public List<Problem> getAllProblems() {
        return problemDao.getAllProblems();
    }

    public Problem getProblemByUuid(UUID uuid) {
        return problemDao.getProblemByUuid(uuid);
    }

    // Update
    public void updateProblem(Problem problem) {
        problemDao.update(problem);
    }

    // Delete
    public void deleteProblemByUuid(UUID uuid) {
        problemDao.deleteByUuid(uuid);
    }

}
