package com.Babaitis.Project.ProblemStore.position.service;

import com.Babaitis.Project.ProblemStore.position.Position;
import com.Babaitis.Project.ProblemStore.position.dao.PositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionService(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    public List<Position> getAllPositions() {
        return positionDao.getAll();
    }
}
