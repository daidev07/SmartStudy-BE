package com.project.smartstudybejava.dto.req;

import com.project.smartstudybejava.entity.ExpandContent;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class QuestionUpdateRequest {
    Long questionId;
    String questionContent;
    Long firstAnswerId;
    String firstAnswerContent;
    boolean isCorrectFirst = false;
    Long secondAnswerId;
    String secondAnswerContent;
    boolean isCorrectSecond = false;
    Long thirdAnswerId;
    String thirdAnswerContent;
    boolean isCorrectThird = false;
    Long fourthAnswerId;
    String fourthAnswerContent;
    boolean isCorrectFourth = false;
    Long expandContentId;
    String expandContent;
}
