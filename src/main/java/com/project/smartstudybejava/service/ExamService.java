package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.Exam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ExamService {
    void createExamWithQuestions(String examName, MultipartFile examFile) throws IOException;

    List<Exam> getAllExams();
}
