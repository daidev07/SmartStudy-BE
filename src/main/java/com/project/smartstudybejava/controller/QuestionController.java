package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.QuestionUpdateRequest;
import com.project.smartstudybejava.entity.Question;
import com.project.smartstudybejava.service.QuestionService;
import com.project.smartstudybejava.util.ErrorCode;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/question")
public class QuestionController {
    QuestionService questionService;

    @PutMapping
    public ResponseData<Question> updateQuestion(QuestionUpdateRequest questionUpdateRequest) {
        try {
            Question updatedQuestion = questionService.updateQuestion(questionUpdateRequest);
            return ResponseData.<Question>builder()
                    .code(SuccessCode.UPDATE_QUESTION_SUCCESSFUL.getCode())
                    .message(SuccessCode.UPDATE_QUESTION_SUCCESSFUL.getMessage())
                    .data(updatedQuestion)
                    .build();
        } catch (Exception e) {
            return ResponseData.<Question>builder()
                    .code(ErrorCode.UPDATE_QUESTION_FAILED.getCode())
                    .message(ErrorCode.UPDATE_QUESTION_FAILED.getMessage())
                    .build();
        }
    }
}
