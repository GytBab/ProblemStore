package com.Babaitis.Project.ProblemStore.problem;

import lombok.*;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Problem {
    private String laser;
    private String effect;
    private String cause;
    private String solution;
    private String partNo;
    private String comment;
    private Blob photo;
}