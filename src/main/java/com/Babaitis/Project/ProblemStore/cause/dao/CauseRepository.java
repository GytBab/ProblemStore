package com.Babaitis.Project.ProblemStore.cause.dao;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CauseRepository extends JpaRepository<Cause, Integer> {
}
