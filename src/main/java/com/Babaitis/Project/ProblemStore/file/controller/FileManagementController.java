package com.Babaitis.Project.ProblemStore.file.controller;

import com.Babaitis.Project.ProblemStore.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class FileManagementController {
    private FileService fileService;

    @Autowired
    public FileManagementController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/upload")
    public String getUploadForm() {
        return "file/upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("image-files") MultipartFile file) {
        fileService.save(file);
        return "redirect:/upload";
    }
}
