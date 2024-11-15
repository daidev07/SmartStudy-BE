package com.project.smartstudybejava.dto.res;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class AnswerResponse {
    private Long id;
    private String content;
    private Boolean isCorrect;
}
