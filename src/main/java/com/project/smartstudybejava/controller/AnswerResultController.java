package com.project.smartstudybejava.controller;


import com.project.smartstudybejava.dto.req.AnswerResultRequestDTO;
import com.project.smartstudybejava.dto.res.AnswerResultResponseDTO;
import com.project.smartstudybejava.service.AnswerResultService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/answer-result")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnswerResultController {
    AnswerResultService answerResultService;
    @PostMapping
    public void submitAnswerResults(@RequestBody List<AnswerResultRequestDTO> answerResults,
                                    @RequestParam("point") Long point) {
        answerResultService.saveAnswerResults(answerResults, point);
    }
    @GetMapping("/user/{userId}/assignment/{studentAssignmentId}")
    public ResponseData<List<AnswerResultResponseDTO>> getAnswerResultsByUserIdAndAssignmentId(@PathVariable Long userId,
                                                        @PathVariable Long studentAssignmentId) {
        return ResponseData.<List<AnswerResultResponseDTO>>builder()
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(answerResultService.getAnswerResultsByUserIdAndAssignmentId(userId, studentAssignmentId))
                .build();
    }
}
