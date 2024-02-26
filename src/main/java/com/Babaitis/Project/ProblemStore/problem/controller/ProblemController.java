package com.Babaitis.Project.ProblemStore.problem.controller;

import com.Babaitis.Project.ProblemStore.HttpEndPoints;
import com.Babaitis.Project.ProblemStore.helper.MessageService;
import com.Babaitis.Project.ProblemStore.problem.dto.ProblemDto;
import com.Babaitis.Project.ProblemStore.problem.exception.ProblemNotFoundException;
import com.Babaitis.Project.ProblemStore.problem.service.ProblemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;
    private final MessageService messageService;

    @GetMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String getFormForCreate(Model model, String message) {
        model.addAttribute("problemDto", ProblemDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));
        problemService.getChoiceForProblemRegistration(model);
        return "problem/problem";
    }


    @GetMapping(HttpEndPoints.PROBLEMS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID problemUuid) {
        model.addAttribute("problemDto", problemService.getProblemByUuid(problemUuid));
        problemService.getChoiceForProblemRegistration(model);
        return "problem/problem";
    }

    @PostMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String createNewProblem(Model model, @Valid ProblemDto problem, BindingResult errors) {
        if (errors.hasErrors()) {
            problemService.getChoiceForProblemRegistration(model);
            return "problem/problem";
        }
        problemService.saveProblem(problem);
        return "redirect:/problems/create?message=problem.create.messages.success";
    }

    @GetMapping(HttpEndPoints.PROBLEMS)
    public String getListOfProblems(Model model,
                                    @PageableDefault(size = 3, sort = {"entryDate"}, direction = Sort.Direction.ASC) Pageable pageable) {
        final Page<ProblemDto> allProblems = problemService.getAllProblemsPage(pageable);
        model.addAttribute("problemList", allProblems);
        return "problem/problems";
    }

    @PostMapping(HttpEndPoints.PROBLEMS_UPDATE)
    public String updateProblem(Model model,
                                ProblemDto problem,
                                @PageableDefault(size = 3, sort = {"entryDate"}, direction = Sort.Direction.ASC) Pageable pageable) {
        problemService.updateProblem(problem);
        return getListOfProblems(model, pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndPoints.PROBLEMS_DELETE)
    public String deleteProblem(Model model,
                                @PathVariable UUID problemUuid,
                                @PageableDefault(size = 3, sort = {"entryDate"}, direction = Sort.Direction.ASC) Pageable pageable) {
        problemService.deleteProblemByUuid(problemUuid);
        return getListOfProblems(model, pageable);
    }

    @ExceptionHandler
    public String problemNotFound(ProblemNotFoundException e, Model model) {
        return "problem/error/problemNotFound";
    }
}
