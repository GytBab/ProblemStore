package com.Babaitis.Project.ProblemStore.cause;

import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer parentId;
    @OneToMany(mappedBy = "cause", cascade = CascadeType.DETACH)
    private List<Problem> problems;

    @Override
    public String toString() {
        return name;
    }
}
