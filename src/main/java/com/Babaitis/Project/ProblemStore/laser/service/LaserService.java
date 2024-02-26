package com.Babaitis.Project.ProblemStore.laser.service;

import com.Babaitis.Project.ProblemStore.laser.dto.LaserDto;
import com.Babaitis.Project.ProblemStore.laser.exception.LaserNotFoundException;
import com.Babaitis.Project.ProblemStore.laser.mapper.LaserMapper;
import com.Babaitis.Project.ProblemStore.laser.pojo.Laser;
import com.Babaitis.Project.ProblemStore.laser.dao.LaserDao;
import com.Babaitis.Project.ProblemStore.laser_data.service.Laser_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;

@Service
public class LaserService {

    private final LaserDao laserDao;
    private final LaserMapper mapper;
    private final Laser_dataService laserDataService;

    @Autowired
    public LaserService(LaserDao laserDao, LaserMapper mapper, Laser_dataService laserDataService) {
        this.laserDao = laserDao;
        this.mapper = mapper;
        this.laserDataService = laserDataService;
    }

    public List<Laser> getAllLasers() {
        return laserDao.getAll();
    }

    @Transactional
    public void saveLaser(LaserDto laserDto) {
        Laser laser = mapper.fromDto(laserDto);
        laserDao.save(laser);
    }

    public Page<LaserDto> getAllLasersPage(Pageable pageable) {
        return laserDao.getPage(pageable).map(mapper::toDto);
    }

    public LaserDto getLaserByUuid(UUID uuid) {
        return laserDao.getLaserByUuid(uuid)
                .map(mapper::toDto)
                .orElseThrow(LaserNotFoundException::new);
    }

    @Transactional
    public void updateLaser(LaserDto laserDto) {
        Laser laserWithNewFields = mapper.fromDto(laserDto);
        Laser laserToUpdate = laserDao.getLaserByUuid(laserWithNewFields.getLaserUuid())
                .orElseThrow(LaserNotFoundException::new);
        laserToUpdate.setModel(laserWithNewFields.getModel());
        laserToUpdate.setSerialNumber(laserWithNewFields.getSerialNumber());
        laserToUpdate.setStatus(laserWithNewFields.getStatus());
        laserToUpdate.setStartDate(laserWithNewFields.getStartDate());
        laserToUpdate.setEndDate(laserWithNewFields.getEndDate());
        laserDao.update(laserToUpdate);
    }

    @Transactional
    public void deleteLaserByUuid(UUID uuid) {
        laserDao.deleteByUuid(uuid);
    }

    public void getChoiceForLaserRegistration(Model model) {
        model.addAttribute("lasers_data", laserDataService.getAllLaser_data());
    }
}
