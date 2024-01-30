package com.Babaitis.Project.ProblemStore.effect.dao;

import com.Babaitis.Project.ProblemStore.effect.Effect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EffectJpaDao implements EffectDao {

    EffectRepository repository;

    @Autowired
    public EffectJpaDao(EffectRepository effectRepository) {
        this.repository = effectRepository;
    }

    @Override
    public List<Effect> getAll() {
        return repository.findAll();
    }
}
