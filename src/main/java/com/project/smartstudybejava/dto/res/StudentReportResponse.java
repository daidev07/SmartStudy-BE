package com.project.smartstudybejava.dto.res;

import com.project.smartstudybejava.entity.AnswerResult;
import com.project.smartstudybejava.entity.StudentAssignment;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StudentReportResponse {
    List<AnswerResult> answerResults;
    List<StudentAssignment> studentAssignments;
    Long totalAskGPT;
}
