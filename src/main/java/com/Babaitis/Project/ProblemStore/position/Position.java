package com.Babaitis.Project.ProblemStore.position;

import com.Babaitis.Project.ProblemStore.employee.pojo.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "positionId")
    private List<Employee> positions;

    @Override
    public String toString() {
        return name;
    }
}
