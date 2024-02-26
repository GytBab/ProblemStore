package com.Babaitis.Project.ProblemStore.laser_data.service;

import com.Babaitis.Project.ProblemStore.laser_data.dao.Laser_dataDao;
import com.Babaitis.Project.ProblemStore.laser_data.pojo.Laser_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Laser_dataService {
    private final Laser_dataDao laserDataDao;

    @Autowired

    public Laser_dataService(Laser_dataDao laser_dataDao) {
        this.laserDataDao = laser_dataDao;
    }

    public List<Laser_data> getAllLaser_data() {
        return laserDataDao.getAll();
    }
}
