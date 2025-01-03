package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.QuestionUpdateRequest;
import com.project.smartstudybejava.entity.Question;

public interface QuestionService {
    Question updateQuestion(QuestionUpdateRequest questionUpdateRequest);
}
