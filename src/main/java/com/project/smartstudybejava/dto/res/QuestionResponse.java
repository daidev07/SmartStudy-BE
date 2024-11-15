package com.project.smartstudybejava.dto.res;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class QuestionResponse {
    private Long id;
    private String content;
    private List<AnswerResponse> answers;
}
