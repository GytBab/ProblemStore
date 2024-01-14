package com.Babaitis.Project.ProblemStore.problem;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProblemDao {

    private Map<UUID, Problem> problems = new HashMap<>();

    // CRUD operations:
    // Create
    public void save(Problem problem) {
        final UUID uuid = UUID.randomUUID();
        problem.setProblemUuid(uuid);
        problems.put(uuid, problem);
    }

    // Read
    public List<Problem> getAllProblems() {
        return new ArrayList<>(problems.values());
    }

    public Problem getProblemByUuid(UUID uuid) {
        return problems.get(uuid);
    }

    // Update
    public void update(Problem problem) {
        problems.put(problem.getProblemUuid(), problem);
    }

    // Delete
    public void deleteByUuid(UUID uuid) {
        problems.remove(uuid);
    }

}
