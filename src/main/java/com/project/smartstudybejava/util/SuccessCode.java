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

    GET_ASSIGNMENT_SUCCESSFUL(200, "Get assignment successful" , HttpStatus.OK),
    ASSIGN_SUCCESSFUL(201, "Assignment to classroom successful" , HttpStatus.CREATED),
    ;

    int code;
    String message;
    HttpStatus httpStatus;
}
