package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.res.ExamResponse;
import com.project.smartstudybejava.entity.Exam;
import com.project.smartstudybejava.service.ExamService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/exams")
public class ExamController {
    ExamService examService;

    @PostMapping()
    public ResponseEntity<String> createExamWithQuestions(@RequestParam("examName") String examName,
                                                          @RequestParam("examFile") MultipartFile examFile) {
        try {
            examService.createExamWithQuestions(examName, examFile);
            return ResponseEntity.ok("Tạo đề thi và import câu hỏi thành công!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Lỗi khi import file: " + e.getMessage());
        }
    }
    @GetMapping
    public ResponseData<List<Exam>> getAllExams() {
        return ResponseData.<List<Exam>>builder()
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(examService.getAllExams())
                .build();
    }

    @GetMapping("/{examId}")
    public ResponseData<ExamResponse> getExamsByExamId(@PathVariable Long examId) {
        return ResponseData.<ExamResponse>builder()
                .message(SuccessCode.GET_EXAM_SUCCESSFUL.getMessage())
                .data(examService.getExamByExamId(examId))
                .build();
    }

}
