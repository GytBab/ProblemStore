package com.Babaitis.Project.ProblemStore.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProblemController {

    private ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/problems/create")
    public String problem(Model model) {
        model.addAttribute("problem", new Problem());
        return "problem";
    }

    @PostMapping("/problems/create")
    public String createNewProduct(Problem problem) {

        problemService.saveProblem(problem);
        System.out.println("currently in the database");
        problemService.getAllProblems().forEach(System.out::println);
        return "welcome/welcome";
    }


}
