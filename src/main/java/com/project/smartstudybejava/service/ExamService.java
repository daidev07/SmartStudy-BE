package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.ExamRequest;
import com.project.smartstudybejava.dto.res.ExamResponse;
import com.project.smartstudybejava.entity.Exam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ExamService {
    Exam  createListeningExam(ExamRequest examRequest) throws IOException;
    Exam createReadingExam(ExamRequest examRequest) throws IOException;
    Exam createGrammarExam(ExamRequest examRequest) throws IOException;
    List<Exam> getAllExams();
    Exam getExamByExamId(Long examId);
}
