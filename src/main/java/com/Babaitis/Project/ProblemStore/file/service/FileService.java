package com.Babaitis.Project.ProblemStore.file.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {

    private final Path fileLocation = Paths.get("./files").toAbsolutePath().normalize();

    public void save(MultipartFile file) {
        try {
            var newFile = new File(generateFilename(file));
            file.transferTo(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getTextFileContents(MultipartFile file) {
        try {
            var reader = new InputStreamReader(file.getInputStream());
            var bufferedReader = new BufferedReader(reader);
            return bufferedReader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateFilename(MultipartFile file) {
        return fileLocation + "/" + file.getOriginalFilename();
    }

    public ByteArrayResource download(String filename) {
        Path path = Paths.get(fileLocation + "/" + filename);
        try {
            return new ByteArrayResource(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
