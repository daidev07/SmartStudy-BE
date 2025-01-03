package com.project.smartstudybejava.dto.res;

import com.project.smartstudybejava.entity.ExpandContent;
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
    Integer questionNumber;
    String content;
    List<AnswerResponse> answers;
    ExpandContent expandContent;
}
