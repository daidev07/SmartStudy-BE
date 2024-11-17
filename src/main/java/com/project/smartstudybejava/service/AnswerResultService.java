package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.AnswerResultRequestDTO;

import java.util.List;

public interface AnswerResultService {
    void saveAnswerResults(List<AnswerResultRequestDTO> answerResults, Long point);
}
