package com.Babaitis.Project.ProblemStore.problem.service;

import com.Babaitis.Project.ProblemStore.problem.Problem;
import com.Babaitis.Project.ProblemStore.problem.dao.ProblemDao;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import com.Babaitis.Project.ProblemStore.problem.mappers.ProblemMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void saveProblem(ProblemDto problemDto) {
        Problem problem = mapper.fromProblemDto(problemDto);
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
    public void updateProblem(ProblemDto problemDto) {

        Problem problemWithNewFields = mapper.fromProblemDto(problemDto);
        Problem problemToUpdate = problemDao.getProblemByUuid(problemWithNewFields.getProblemUuid());
        // Merging old problem in the database with the new values obtained from frontEnd
        problemToUpdate.setLaser(problemWithNewFields.getLaser());
        problemToUpdate.setEffect(problemWithNewFields.getEffect());
        problemToUpdate.setCause(problemWithNewFields.getCause());
        problemToUpdate.setSolution(problemWithNewFields.getSolution());
        problemToUpdate.setEntryDate(problemWithNewFields.getEntryDate());
        problemToUpdate.setPartNo(problemWithNewFields.getPartNo());
        problemToUpdate.setComment(problemWithNewFields.getComment());
        problemToUpdate.setPhotos(problemWithNewFields.getPhotos());
        problemDao.update(problemToUpdate);
    }

    // Delete
    public void deleteProblemByUuid(UUID uuid) {
        problemDao.deleteByUuid(uuid);
    }

}
