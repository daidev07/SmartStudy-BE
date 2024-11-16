package com.project.smartstudybejava.dto.req;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignmentRequest {
    String title;
    String description;
    LocalDateTime dueDate;
    Long totalPoints = 0L;
}
