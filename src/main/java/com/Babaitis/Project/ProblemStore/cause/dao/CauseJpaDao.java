package com.Babaitis.Project.ProblemStore.cause.dao;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CauseJpaDao implements CauseDao {

    CauseRepository repository;

    @Autowired
    public CauseJpaDao(CauseRepository causeRepository) {
        this.repository = causeRepository;
    }

    @Override
    public List<Cause> getAll() {
        return repository.findAll();
    }

}
