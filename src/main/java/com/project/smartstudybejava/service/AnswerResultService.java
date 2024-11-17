package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.AnswerResultRequestDTO;
import com.project.smartstudybejava.dto.res.AnswerResultResponseDTO;

import java.util.List;

public interface AnswerResultService {
    void saveAnswerResults(List<AnswerResultRequestDTO> answerResults, Long point);
    List<AnswerResultResponseDTO> getAnswerResultsByUserIdAndAssignmentId(Long userId, Long studentAssignmentId);
}
