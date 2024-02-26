package com.Babaitis.Project.ProblemStore.laser.dao;

import com.Babaitis.Project.ProblemStore.laser.pojo.Laser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LaserJpaDao implements LaserDao{

    LaserRepository repository;

    @Autowired
    public LaserJpaDao(LaserRepository laserRepository) {
        this.repository = laserRepository;
    }

    @Override
    public List<Laser> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Laser laser) {
        laser.setLaserUuid(UUID.randomUUID());
        repository.save(laser);
    }

    @Override
    public Page<Laser> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Laser> getLaserByUuid(UUID uuid) {
        return repository.findLaserByLaserUuid(uuid);
    }

    @Override
    public void update(Laser laser) {
        repository.save(laser);
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        repository.deleteByLaserUuid(uuid);
    }
}
