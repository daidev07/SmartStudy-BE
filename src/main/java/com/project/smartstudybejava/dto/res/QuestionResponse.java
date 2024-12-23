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
    Long id;
    String content;
    List<AnswerResponse> answers;
}
