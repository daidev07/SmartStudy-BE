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
    Long id;
    Long userId;
    Long studentAssignmentId;
    Long questionId;
    Long answerId;
}
