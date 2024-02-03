package com.Babaitis.Project.ProblemStore.problem.service;

import com.Babaitis.Project.ProblemStore.cause.service.CauseService;
import com.Babaitis.Project.ProblemStore.effect.service.EffectService;
import com.Babaitis.Project.ProblemStore.laser.LaserService;
import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import com.Babaitis.Project.ProblemStore.problem.dao.ProblemDao;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import com.Babaitis.Project.ProblemStore.problem.exception.ProblemNotFoundException;
import com.Babaitis.Project.ProblemStore.problem.mapper.ProblemMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.UUID;

@Service
@Transactional
public class ProblemService {

    private final ProblemDao problemDao;
    private final ProblemMapper mapper;
    private final CauseService causeService;
    private final EffectService effectService;
    private final LaserService laserService;

    @Autowired
    public ProblemService(ProblemDao problemDao, ProblemMapper mapper, CauseService causeService, EffectService effectService, LaserService laserService) {
        this.problemDao = problemDao;
        this.mapper = mapper;
        this.causeService = causeService;
        this.effectService = effectService;
        this.laserService = laserService;
    }

    // CRUD operations:
    // Create
    @Transactional
    public void saveProblem(ProblemDto problemDto) {
        Problem problem = mapper.fromProblemDto(problemDto);
        problemDao.save(problem);
    }

    // Read
    public Page<ProblemDto> getAllProblemsPage(Pageable pageable) {
        return problemDao.getPage(pageable).map(problem -> mapper.toProblemDto(problem));
    }

    public ProblemDto getProblemByUuid(UUID uuid) {
        return problemDao.getProblemByUuid(uuid)
                .map(mapper::toProblemDto)
                .orElseThrow(ProblemNotFoundException::new);
    }

    // Update
    @Transactional
    public void updateProblem(ProblemDto problemDto) {

        Problem problemWithNewFields = mapper.fromProblemDto(problemDto);
        Problem problemToUpdate = problemDao.getProblemByUuid(problemWithNewFields.getProblemUuid())
                .orElseThrow(ProblemNotFoundException::new);
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
    @Transactional
    public void deleteProblemByUuid(UUID uuid) {
        problemDao.deleteByUuid(uuid);
    }

    public void getChoiceForProblemRegistration(Model model) {
        model.addAttribute("causes", causeService.getAllCauses());
        model.addAttribute("effects", effectService.getAllEffects());
        model.addAttribute("lasers", laserService.getAllLasers());
    }
}
