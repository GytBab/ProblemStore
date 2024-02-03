package com.Babaitis.Project.ProblemStore.problem.dao;

import com.Babaitis.Project.ProblemStore.problem.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProblemDao {
    void save(Problem problem);
    List<Problem> getAllProblems();
    Page<Problem> getPage(Pageable pageable);
    Optional<Problem> getProblemByUuid(UUID uuid);
    void update(Problem problem);
    void deleteByUuid(UUID uuid);


}
