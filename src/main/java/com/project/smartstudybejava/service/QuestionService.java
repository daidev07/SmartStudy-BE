package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.QuestionUpdateRequest;
import com.project.smartstudybejava.dto.res.QuestionResponse;
import com.project.smartstudybejava.entity.Question;

public interface QuestionService {
    QuestionResponse updateQuestion(QuestionUpdateRequest questionUpdateRequest);
    QuestionResponse getQuestionById(Long questionId);
}
