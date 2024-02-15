package com.Babaitis.Project.ProblemStore.fakes;

import com.Babaitis.Project.ProblemStore.problem.dao.ProblemDao;
import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakeProblemDao implements ProblemDao {

    private HashMap<UUID, Problem> storage;

    public FakeProblemDao() {
        this.storage = new HashMap<>();
    }
    @Override
    public void save(Problem problem) {
        problem.setId(storage.size() + 1);
        storage.put(problem.getProblemUuid(), problem);
    }

    @Override
    public List<Problem> getAllProblems() {
        return storage.values().stream().toList();
    }

    @Override
    public Page<Problem> getPage(Pageable pageable) {
        return Page.empty();
    }

    @Override
    public Optional<Problem> getProblemByUuid(UUID uuid) {
        return Optional.of(storage.get(uuid));
    }

    @Override
    public void update(Problem problem) {
        storage.put(problem.getProblemUuid(), problem);
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        storage.remove(uuid);
    }
}
