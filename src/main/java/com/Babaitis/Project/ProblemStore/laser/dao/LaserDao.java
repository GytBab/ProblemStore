package com.Babaitis.Project.ProblemStore.laser.dao;

import com.Babaitis.Project.ProblemStore.laser.pojo.Laser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LaserDao {

    List<Laser> getAll();
    void save(Laser laser);
    Page<Laser> getPage(Pageable pageable);
    Optional<Laser> getLaserByUuid(UUID uuid);
    void update(Laser laser);
    void deleteByUuid(UUID uuid);
}
