package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.ExamRequest;
import com.project.smartstudybejava.entity.Exam;
import com.project.smartstudybejava.service.ExamService;
import com.project.smartstudybejava.util.ErrorCode;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/exam")
public class ExamController {
    ExamService examService;

    @PostMapping("/listening")
    public ResponseData<Exam> createListeningExam(@ModelAttribute ExamRequest examRequest) {
        try {
            Exam exam = examService.createListeningExam(examRequest);
            return ResponseData.<Exam>builder()
                    .code(SuccessCode.CREATE_EXAM_SUCCESSFUL.getCode())
                    .message(SuccessCode.CREATE_EXAM_SUCCESSFUL.getMessage())
                    .data(exam)
                    .build();
        } catch (IOException e) {
            return ResponseData.<Exam>builder()
                    .code(ErrorCode.CREATE_EXAM_FAILED.getCode())
                    .message(ErrorCode.CREATE_EXAM_FAILED.getMessage())
                    .build();
        }
    }
    @PostMapping("/reading")
    public ResponseData<Exam> createReadingExam(@ModelAttribute ExamRequest examRequest) {
        try {
            Exam exam = examService.createReadingExam(examRequest);
            return ResponseData.<Exam>builder()
                    .code(SuccessCode.CREATE_EXAM_SUCCESSFUL.getCode())
                    .message(SuccessCode.CREATE_EXAM_SUCCESSFUL.getMessage())
                    .data(exam)
                    .build();
        } catch (IOException e) {
            return ResponseData.<Exam>builder()
                    .code(ErrorCode.CREATE_EXAM_FAILED.getCode())
                    .message(ErrorCode.CREATE_EXAM_FAILED.getMessage())
                    .build();
        }
    }
    @PostMapping("/grammar")
    public ResponseData<Exam> createGrammarExam(@ModelAttribute ExamRequest examRequest) {
        try {
            Exam exam = examService.createGrammarExam(examRequest);
            return ResponseData.<Exam>builder()
                    .code(SuccessCode.CREATE_EXAM_SUCCESSFUL.getCode())
                    .message(SuccessCode.CREATE_EXAM_SUCCESSFUL.getMessage())
                    .data(exam)
                    .build();
        } catch (IOException e) {
            return ResponseData.<Exam>builder()
                    .code(ErrorCode.CREATE_EXAM_FAILED.getCode())
                    .message(ErrorCode.CREATE_EXAM_FAILED.getMessage())
                    .build();
        }
    }
    @GetMapping
    public ResponseData<List<Exam>> getAllExams() {
        return ResponseData.<List<Exam>>builder()
                .code(SuccessCode.GET_ALL_EXAM_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ALL_EXAM_SUCCESSFUL.getMessage())
                .data(examService.getAllExams())
                .build();
    }

    @GetMapping("/{examId}")
    public ResponseData<Exam> getExamByExamId(@PathVariable Long examId) {
        return ResponseData.<Exam>builder()
                .code(SuccessCode.GET_EXAM_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_EXAM_SUCCESSFUL.getMessage())
                .data(examService.getExamByExamId(examId))
                .build();
    }

}
