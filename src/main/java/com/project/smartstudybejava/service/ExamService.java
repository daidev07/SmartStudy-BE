package com.project.smartstudybejava.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ExamService {
    void createExamWithQuestions(String name, MultipartFile file) throws IOException;
}
