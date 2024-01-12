package com.Babaitis.Project.ProblemStore.problem;

import lombok.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

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
    private Time startTime;
    private Time endTime;
    private Time time;
    private Date entryDate;
    private String partNo;
    private String comment;
    private Blob photo;
}