package com.Babaitis.Project.ProblemStore.employee;

import com.Babaitis.Project.ProblemStore.laser_data.Laser_data;
import com.Babaitis.Project.ProblemStore.position.Position;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID employeeUuid;
    private String name;
    private String surname;
    private String email;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position positionId;
    @OneToMany(mappedBy = "team_lead")
    private List<Laser_data> laserDataList;
}
