package com.Babaitis.Project.ProblemStore.laser.mapper;

import com.Babaitis.Project.ProblemStore.common.mapper.Mapper;
import com.Babaitis.Project.ProblemStore.laser.dto.LaserDto;
import com.Babaitis.Project.ProblemStore.laser.pojo.Laser;
import org.springframework.stereotype.Component;

@Component
public class LaserMapper implements Mapper<Laser, LaserDto> {

    public LaserDto toDto(Laser laser) {
        return LaserDto.builder()
                .laserUuid(laser.getLaserUuid())
                .model(laser.getModel())
                .serialNumber(laser.getSerialNumber())
                .status(laser.getStatus())
                .startDate(laser.getStartDate())
                .endDate(laser.getEndDate())
                .build();
    }

    public Laser fromDto(LaserDto laserDto) {
        return Laser.builder()
                .laserUuid(laserDto.getLaserUuid())
                .model(laserDto.getModel())
                .serialNumber(laserDto.getSerialNumber())
                .status(laserDto.getStatus())
                .startDate(laserDto.getStartDate())
                .endDate(laserDto.getEndDate())
                .build();
    }
}
