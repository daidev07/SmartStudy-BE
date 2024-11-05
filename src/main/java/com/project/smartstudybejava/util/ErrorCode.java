package com.project.smartstudybejava.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    IMAGE_OVERSIZE(1001, "Image oversize", HttpStatus.BAD_REQUEST),;
    int code;
    String message;
    HttpStatus httpStatus;
}
