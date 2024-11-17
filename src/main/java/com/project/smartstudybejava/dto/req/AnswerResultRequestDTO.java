package com.project.smartstudybejava.dto.req;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class AnswerResultRequestDTO {
    Long studentAssignmentId;
    Long questionId;
    Long answerId;
    Long userId;
}
