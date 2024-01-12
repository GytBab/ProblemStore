package com.Babaitis.Project.ProblemStore.problem;

import com.Babaitis.Project.ProblemStore.HttpEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProblemController {

    private ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String problem(Model model) {
        model.addAttribute("problem", new Problem());
        return "problem/problem";
    }

    @PostMapping(HttpEndPoints.PROBLEMS_CREATE)
    public String createNewProduct(Problem problem) {
        problemService.saveProblem(problem);
        System.out.println("currently in the database");
        problemService.getAllProblems().forEach(System.out::println);
        return "/welcome/welcome";
    }

    @GetMapping(HttpEndPoints.PROBLEMS)
    public String getListOfProblems(Model model) {
        final List<Problem> allProblems = problemService.getAllProblems();
        model.addAttribute("problemList", allProblems);
        return "problem/problems";
    }

}
