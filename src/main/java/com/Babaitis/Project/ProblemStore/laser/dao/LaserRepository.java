package com.Babaitis.Project.ProblemStore.laser.dao;

import com.Babaitis.Project.ProblemStore.laser.pojo.Laser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LaserRepository extends JpaRepository<Laser, Long> {

    Optional<Laser> findLaserByLaserUuid(UUID uuid);

    void deleteByLaserUuid(UUID uuid);
}
