package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.QuestionUpdateRequest;
import com.project.smartstudybejava.dto.res.QuestionResponse;
import com.project.smartstudybejava.entity.Question;
import com.project.smartstudybejava.service.QuestionService;
import com.project.smartstudybejava.util.ErrorCode;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/question")
public class QuestionController {
    QuestionService questionService;

    @PutMapping()
    public ResponseData<QuestionResponse> updateQuestion(@RequestBody QuestionUpdateRequest questionUpdateRequest) {
        try {
            QuestionResponse updatedQuestion = questionService.updateQuestion(questionUpdateRequest);
            return ResponseData.<QuestionResponse>builder()
                    .code(SuccessCode.UPDATE_QUESTION_SUCCESSFUL.getCode())
                    .message(SuccessCode.UPDATE_QUESTION_SUCCESSFUL.getMessage())
                    .data(updatedQuestion)
                    .build();
        } catch (Exception e) {
            return ResponseData.<QuestionResponse>builder()
                    .code(ErrorCode.UPDATE_QUESTION_FAILED.getCode())
                    .message(ErrorCode.UPDATE_QUESTION_FAILED.getMessage())
                    .build();
        }
    }
    @GetMapping("/{questionId}")
    public ResponseData<QuestionResponse> getQuestionById(@PathVariable Long questionId) {
        try {
            QuestionResponse questionResponse = questionService.getQuestionById(questionId);
            return ResponseData.<QuestionResponse>builder()
                    .code(SuccessCode.GET_QUESTION_SUCCESSFUL.getCode())
                    .message(SuccessCode.GET_QUESTION_SUCCESSFUL.getMessage())
                    .data(questionResponse)
                    .build();
        } catch (Exception e) {
            return ResponseData.<QuestionResponse>builder()
                    .code(ErrorCode.GET_QUESTION_FAILED.getCode())
                    .message(ErrorCode.GET_QUESTION_FAILED.getMessage())
                    .build();
        }
    }
}
