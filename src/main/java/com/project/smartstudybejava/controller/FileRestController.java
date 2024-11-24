package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.service.CloudinaryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileRestController {
    CloudinaryService cloudinaryService;

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("avatar") MultipartFile avatar) throws IOException {
        return ResponseEntity.ok(cloudinaryService.saveFile(avatar));
    }
}
