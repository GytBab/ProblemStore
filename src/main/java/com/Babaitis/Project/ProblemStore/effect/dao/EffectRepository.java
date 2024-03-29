package com.Babaitis.Project.ProblemStore.effect.dao;

import com.Babaitis.Project.ProblemStore.effect.Effect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends JpaRepository<Effect, Integer> {
}
