package com.Babaitis.Project.ProblemStore.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/hello")
    public String showWelcomePage() {
        return "welcome/welcome";
    }
}
