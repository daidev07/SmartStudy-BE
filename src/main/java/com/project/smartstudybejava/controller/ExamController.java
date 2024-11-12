package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.service.ExamService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/exams")
public class ExamController {
    ExamService examService;

    @PostMapping("/create")
    public ResponseEntity<String> createExamWithQuestions(@RequestParam("name") String name,
                                                          @RequestParam("file") MultipartFile file) {
        try {
            examService.createExamWithQuestions(name, file);
            return ResponseEntity.ok("Tạo đề thi và import câu hỏi thành công!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Lỗi khi import file: " + e.getMessage());
        }
    }

}
