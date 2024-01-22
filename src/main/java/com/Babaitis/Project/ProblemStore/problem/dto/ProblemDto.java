package com.Babaitis.Project.ProblemStore.problem.dto;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import com.Babaitis.Project.ProblemStore.effect.Effect;
import com.Babaitis.Project.ProblemStore.laser.Laser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProblemDto {
    private UUID problemUuid;
    private Laser laser;
    private Effect effect;
    private Cause cause;
    private String solution;
    private String partNo;
    private String entry_date;
    private String comment;
    private String photos;
}