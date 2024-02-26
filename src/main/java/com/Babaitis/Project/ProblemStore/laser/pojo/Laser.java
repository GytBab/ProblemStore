package com.Babaitis.Project.ProblemStore.laser.pojo;

import com.Babaitis.Project.ProblemStore.laser_data.pojo.Laser_data;
import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
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
public class Laser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID laserUuid;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "model")
    private Laser_data model;
    private String serialNumber;
    private String status;
    private String startDate;
    private String endDate;
    @OneToMany(mappedBy = "laser", cascade = CascadeType.DETACH)
    private List<Problem> problems;

    @Override
    public String toString() {
        return serialNumber;
    }
}
