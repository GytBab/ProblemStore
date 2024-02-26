package com.Babaitis.Project.ProblemStore.laser.controller;

import com.Babaitis.Project.ProblemStore.HttpEndPoints;
import com.Babaitis.Project.ProblemStore.helper.MessageService;
import com.Babaitis.Project.ProblemStore.laser.dto.LaserDto;
import com.Babaitis.Project.ProblemStore.laser.exception.LaserNotFoundException;
import com.Babaitis.Project.ProblemStore.laser.service.LaserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class LaserController {

    private final LaserService laserService;
    private final MessageService messageService;

    @GetMapping(HttpEndPoints.LASERS)
    public String getListOfLasers(Model model,
                                  @PageableDefault(size = 3, sort = {"model"}, direction = Sort.Direction.ASC) Pageable pageable) {
        final Page<LaserDto> allLasers = laserService.getAllLasersPage(pageable);
        model.addAttribute("laserList", allLasers);
        return "laser/lasers";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndPoints.LASERS_CREATE)
    public String getLaserForm(Model model, String message) {
        model.addAttribute("laserDto", LaserDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));
        laserService.getChoiceForLaserRegistration(model);
        return "laser/laser";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(HttpEndPoints.LASERS_CREATE)
    public String registerNewLaser(Model model, @Valid LaserDto laser, BindingResult errors) {
        if (errors.hasErrors()) {
            laserService.getChoiceForLaserRegistration(model);
            return "laser/laser";
        }
        laserService.saveLaser(laser);
        return "redirect:/lasers/create?message=problem.create.messages.success";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndPoints.LASERS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID laserUuid) {
        model.addAttribute("laserDto", laserService.getLaserByUuid(laserUuid));
        laserService.getChoiceForLaserRegistration(model);
        return "laser/laser";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(HttpEndPoints.LASERS_UPDATE)
    public String updateLaser(Model model,
                              LaserDto laserDto,
                              @PageableDefault(size = 3, sort = {"model"}, direction = Sort.Direction.ASC) Pageable pageable) {
        laserService.updateLaser(laserDto);
        return getListOfLasers(model, pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndPoints.LASERS_DELETE)
    public String deleteLaser(Model model,
                              @PathVariable UUID laserUuid,
                              @PageableDefault(size = 3, sort = {"model"}, direction = Sort.Direction.ASC) Pageable pageable) {
        laserService.deleteLaserByUuid(laserUuid);
        return getListOfLasers(model, pageable);
    }

    @ExceptionHandler
    public String laserNotFound(LaserNotFoundException e, Model model) {
        return "laser/error/problemNotFound";
    }
}
