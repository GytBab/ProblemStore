package com.Babaitis.Project.ProblemStore.laser_data.dao;

import com.Babaitis.Project.ProblemStore.laser_data.pojo.Laser_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Laser_dataRepository extends JpaRepository<Laser_data, Integer> {
}
