package com.Babaitis.Project.ProblemStore.laser.dao;

import com.Babaitis.Project.ProblemStore.laser.Laser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
