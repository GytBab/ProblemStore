package com.Babaitis.Project.ProblemStore.laser;

import com.Babaitis.Project.ProblemStore.laser_data.Laser_data;
import com.Babaitis.Project.ProblemStore.problem.Problem;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
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
    private String serial_number;
    private String status;
    private Date start_date;
    private Date end_date;
    @OneToMany(mappedBy = "laser", cascade = CascadeType.DETACH)
    private List<Problem> problems;

    @Override
    public String toString() {
        return serial_number;
    }
}
