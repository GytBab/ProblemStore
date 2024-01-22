package com.Babaitis.Project.ProblemStore.problem;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import com.Babaitis.Project.ProblemStore.effect.Effect;
import com.Babaitis.Project.ProblemStore.laser.Laser;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID problemUuid;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "laser_id")
    private Laser laser;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "effect_id")
    private Effect effect;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cause_id")
    private Cause cause;
    private String solution;
    private String partNo;
    private String entryDate;
    private String comment;
    private String photos;
}