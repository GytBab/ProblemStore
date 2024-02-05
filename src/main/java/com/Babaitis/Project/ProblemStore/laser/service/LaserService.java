package com.Babaitis.Project.ProblemStore.laser.service;

import com.Babaitis.Project.ProblemStore.laser.Laser;
import com.Babaitis.Project.ProblemStore.laser.dao.LaserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaserService {

    private LaserDao laserDao;

    @Autowired
    public LaserService(LaserDao laserDao) {
        this.laserDao = laserDao;
    }

    public List<Laser> getAllLasers() {
        return laserDao.getAll();
    }
}
