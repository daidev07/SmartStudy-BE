package com.project.smartstudybejava.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Getter
@Setter
public class BadRequestException extends RuntimeException {
    int code;
    String message;

    public BadRequestException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
