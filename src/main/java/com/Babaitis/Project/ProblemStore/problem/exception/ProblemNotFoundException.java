package com.Babaitis.Project.ProblemStore.problem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProblemNotFoundException extends RuntimeException{
}
