package com.Babaitis.Project.ProblemStore.cause.service;

import com.Babaitis.Project.ProblemStore.cause.Cause;
import com.Babaitis.Project.ProblemStore.cause.dao.CauseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CauseService {

    private CauseDao causeDao;

    @Autowired
    public CauseService(CauseDao causeDao) {
        this.causeDao = causeDao;
    }

    public List<Cause> getAllCauses() {
        return causeDao.getAll();
    }
}
