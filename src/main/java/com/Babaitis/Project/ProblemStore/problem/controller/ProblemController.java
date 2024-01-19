package com.Babaitis.Project.ProblemStore.problem.controller;

import com.Babaitis.Project.ProblemStore.HttpEndPoints;
import com.Babaitis.Project.ProblemStore.problem.Problem;
import com.Babaitis.Project.ProblemStore.problem.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.UUID;

@Controller
public class ProblemController {

    private ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String getFormForCreate(Model model) {
        model.addAttribute("problem", Problem.builder().build());
        return "problem/problem";
    }

    @GetMapping(HttpEndPoints.PROBLEMS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID problemUuid) {
        model.addAttribute("problem", problemService.getProblemByUuid(problemUuid));
        return "problem/problem";
    }

    @PostMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String createNewProblem(Model model, Problem problem) {
        problemService.saveProblem(problem);
        model.addAttribute("message", "Problem was registered successfully!");
        return "problem/problem";
    }

    @GetMapping(HttpEndPoints.PROBLEMS)
    public String getListOfProblems(Model model) {
        final List<Problem> allProblems = problemService.getAllProblems();
        model.addAttribute("problemList", allProblems);
        return "problem/problems";
    }

    @PostMapping(HttpEndPoints.PROBLEMS_UPDATE)
    public String updateProblem(Model model, Problem problem, @PathVariable UUID problemUuid) {
        problemService.updateProblem(problem);
        return getListOfProblems(model);
    }

    @GetMapping(HttpEndPoints.PROBLEMS_DELETE)
    public String deleteProblem(Model model, @PathVariable UUID problemUuid) {
        problemService.deleteProblemByUuid(problemUuid);
        return getListOfProblems(model);
    }

}
