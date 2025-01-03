package com.project.smartstudybejava.dto.req;

import com.project.smartstudybejava.entity.ExpandContent;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class QuestionUpdateRequest {
    Long questionId;
    Integer questionNumber;
    String questionContent;
    Long firstAnswerId;
    String firstAnswerContent;
    boolean correctFirst = false;
    Long secondAnswerId;
    String secondAnswerContent;
    boolean correctSecond = false;
    Long thirdAnswerId;
    String thirdAnswerContent;
    boolean correctThird = false;
    Long fourthAnswerId;
    String fourthAnswerContent;
    boolean correctFourth = false;
    Long expandContentId;
    String expandContent;
}
