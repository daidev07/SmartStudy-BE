package com.project.smartstudybejava.dto.res;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ExamResponse {
    private Long id;
    private String name;
    private LocalDate createdAt;
    private List<QuestionResponse> questions;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class QuestionResponse {
        private Long id;
        private String content;
        private List<AnswerResponse> answers;

    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AnswerResponse {
        private Long id;
        private String content;
        private Boolean isCorrect;

    }
}
