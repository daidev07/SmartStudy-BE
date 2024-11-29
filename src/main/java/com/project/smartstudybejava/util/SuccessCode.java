package com.project.smartstudybejava.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum SuccessCode {
    CREATED(201, "Success Created" , HttpStatus.CREATED),
    GET_SUCCESSFUL(200, "Get Successful" , HttpStatus.OK),

    GET_EXAM_SUCCESSFUL(200, "Get Exam Successful" , HttpStatus.OK),
    CREATE_EXAM_SUCCESSFUL(201, "Create exam successful" , HttpStatus.CREATED),

    GET_ASSIGNMENT_SUCCESSFUL(200, "Get assignment successful" , HttpStatus.OK),
    ASSIGN_SUCCESSFUL(201, "Assignment to classroom successful" , HttpStatus.CREATED),

    POST_SUCCESSFUL(201, "Post successful" , HttpStatus.CREATED),

    ;

    int code;
    String message;
    HttpStatus httpStatus;
}
