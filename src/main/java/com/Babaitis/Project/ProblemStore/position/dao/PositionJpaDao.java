package com.Babaitis.Project.ProblemStore.position.dao;

import com.Babaitis.Project.ProblemStore.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionJpaDao implements PositionDao {

    PositionRepository repository;

    @Autowired
    public PositionJpaDao(PositionRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Position> getAll() {
        return repository.findAll();
    }
}
