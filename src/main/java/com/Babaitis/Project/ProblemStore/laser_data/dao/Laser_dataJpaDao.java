package com.Babaitis.Project.ProblemStore.laser_data.dao;

import com.Babaitis.Project.ProblemStore.laser_data.pojo.Laser_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Laser_dataJpaDao implements Laser_dataDao {

    Laser_dataRepository repository;

    @Autowired
    public Laser_dataJpaDao(Laser_dataRepository laser_dataRepository) {
        this.repository = laser_dataRepository;
    }

    @Override
    public List<Laser_data> getAll(){
        return repository.findAll();
    }
}
