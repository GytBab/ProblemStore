package com.Babaitis.Project.ProblemStore.laser_data;

import com.Babaitis.Project.ProblemStore.employee.Employee;
import com.Babaitis.Project.ProblemStore.laser.Laser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Laser_data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "team_lead")
    private Employee team_lead;
    private String pulse_length;
    private String type;
    private String model;
    @OneToMany(mappedBy = "model")
    private List<Laser> lasers;

}
