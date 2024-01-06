package com.Babaitis.Project.ProblemStore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestContorller {

    @GetMapping("/hello")
    public String testPage(){
        return "hello";
    }
}
