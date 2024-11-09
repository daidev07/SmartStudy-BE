package com.project.smartstudybejava.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    IMAGE_OVERSIZE(400, "Image oversize", HttpStatus.BAD_REQUEST),

    USER_EXISTED(400, "User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(404, "User not found", HttpStatus.NOT_FOUND),

    UNDEFINED_STUDY_STATUS(404, "Undefined study status enum", HttpStatus.BAD_REQUEST),

    CLASSROOM_NOT_FOUND(404, "Classroom not found", HttpStatus.NOT_FOUND),
    CLASSROOM_EXISTED(400, "Classroom existed", HttpStatus.BAD_REQUEST),



    ;
    int code;
    String message;
    HttpStatus httpStatus;
}
