package com.Babaitis.Project.ProblemStore.problem.service;

import com.Babaitis.Project.ProblemStore.problem.Problem;
import com.Babaitis.Project.ProblemStore.problem.dao.ProblemDao;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import com.Babaitis.Project.ProblemStore.problem.mappers.ProblemMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProblemService {

    private ProblemDao problemDao;
    private ProblemMapper mapper;

    @Autowired
    public ProblemService(ProblemDao problemDao, ProblemMapper mapper) {
        this.problemDao = problemDao;
        this.mapper = mapper;
    }

    // CRUD operations:
    // Create
    public void saveProblem(Problem problem) {
        problemDao.save(problem);
    }

    // Read
    public Page<ProblemDto> getAllProblemsPage(Pageable pageable) {
        return problemDao.getPage(pageable).map(problem -> mapper.toProblemDto(problem));
    }

    public ProblemDto getProblemByUuid(UUID uuid) {
        return mapper.toProblemDto(problemDao.getProblemByUuid(uuid));
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
