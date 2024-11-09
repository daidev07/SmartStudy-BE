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

    ;

    int code;
    String message;
    HttpStatus httpStatus;
}
