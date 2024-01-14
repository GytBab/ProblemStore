package com.Babaitis.Project.ProblemStore.problem;

import lombok.*;
import java.sql.Blob;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Problem {
    private UUID problemUuid;
    private String laser;
    private String effect;
    private String cause;
    private String solution;
    private String partNo;
    private String comment;
    private Blob photo;
}