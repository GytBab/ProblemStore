package com.Babaitis.Project.ProblemStore.laser.dto;

import com.Babaitis.Project.ProblemStore.laser_data.pojo.Laser_data;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class LaserDto {

        private UUID laserUuid;
        private Laser_data model;
        private String serialNumber;
        private String status;
        @NotBlank (message = "{laser.start_date.not.blank}")
        private String startDate;
        public String endDate;

}
