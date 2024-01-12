package com.Babaitis.Project.ProblemStore.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {

    private ProblemDao problemDao;

    @Autowired
    public ProblemService(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }

    public void saveProblem(Problem problem) {
        problemDao.save(problem);
    }

    public List<Problem> getAllProblems() {
        return problemDao.getAllProblems();
    }
}
