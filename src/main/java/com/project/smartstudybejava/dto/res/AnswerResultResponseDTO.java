package com.project.smartstudybejava.dto.res;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class AnswerResultResponseDTO {
    private Long id;
    private Long userId;
    private Long studentAssignmentId;
    private Long questionId;
    private Long answerId;
}
