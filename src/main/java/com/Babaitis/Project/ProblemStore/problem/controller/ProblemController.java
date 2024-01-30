package com.Babaitis.Project.ProblemStore.problem.controller;

import com.Babaitis.Project.ProblemStore.HttpEndPoints;
import com.Babaitis.Project.ProblemStore.cause.dao.CauseDao;
import com.Babaitis.Project.ProblemStore.effect.dao.EffectDao;
import com.Babaitis.Project.ProblemStore.helper.MessageService;
import com.Babaitis.Project.ProblemStore.laser.dao.LaserDao;
import com.Babaitis.Project.ProblemStore.problem.Problem;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import com.Babaitis.Project.ProblemStore.problem.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;
    private final MessageService messageService;
    private final CauseDao causeDao;
    private final EffectDao effectDao;
    private final LaserDao laserDao;


    @GetMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String getFormForCreate(Model model, String message) {
        model.addAttribute("problem", Problem.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));
        model.addAttribute("causes", causeDao.getAll());
        model.addAttribute("effects", effectDao.getAll());
        model.addAttribute("lasers", laserDao.getAll());
        return "problem/problem";
    }

    @GetMapping(HttpEndPoints.PROBLEMS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID problemUuid) {
        model.addAttribute("problem", problemService.getProblemByUuid(problemUuid));
        model.addAttribute("causes", causeDao.getAll());
        model.addAttribute("effects", effectDao.getAll());
        model.addAttribute("lasers", laserDao.getAll());
        return "problem/problem";
    }

    @PostMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String createNewProblem(Problem problem) {
        problemService.saveProblem(problem);
        return "redirect:/problem/problem?message=problem.create.messages.success";
    }

    @GetMapping(HttpEndPoints.PROBLEMS)
    public String getListOfProblems(Model model,
                                    @PageableDefault(size = 3, sort = {"entryDate"}, direction = Sort.Direction.ASC) Pageable pageable) {
        final Page<ProblemDto> allProblems = problemService.getAllProblemsPage(pageable);
        model.addAttribute("problemList", allProblems);
        return "problem/problems";
    }

    @PostMapping(HttpEndPoints.PROBLEMS_UPDATE)
    public String updateProblem(Model model, Problem problem, Pageable pageable) {
        problemService.updateProblem(problem);
        return getListOfProblems(model, pageable);
    }

    @GetMapping(HttpEndPoints.PROBLEMS_DELETE)
    public String deleteProblem(Model model,
                                @PathVariable UUID problemUuid,
                                @PageableDefault(size = 3, sort = {"entryDate"}, direction = Sort.Direction.ASC) Pageable pageable) {
        problemService.deleteProblemByUuid(problemUuid);
        return getListOfProblems(model, pageable);
    }
}
