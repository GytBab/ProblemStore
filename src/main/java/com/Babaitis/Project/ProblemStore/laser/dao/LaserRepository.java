package com.Babaitis.Project.ProblemStore.laser.dao;

import com.Babaitis.Project.ProblemStore.laser.Laser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaserRepository extends JpaRepository<Laser, Long> {
}
