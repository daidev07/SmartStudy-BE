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

    USER_EXISTED(414, "User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(404, "User not found", HttpStatus.NOT_FOUND),

    UNDEFINED_STUDY_STATUS(404, "Undefined study status enum", HttpStatus.BAD_REQUEST),

    CLASSROOM_NOT_FOUND(404, "Classroom not found", HttpStatus.NOT_FOUND),
    CLASSROOM_EXISTED(430, "Classroom existed", HttpStatus.BAD_REQUEST),

    CREATE_EXAM_FAILED(400, "Create exam failed", HttpStatus.BAD_REQUEST),
    EXAM_EXISTED(400, "Exam existed", HttpStatus.BAD_REQUEST),
    EXAM_NOT_FOUND(404, "Exam not found", HttpStatus.NOT_FOUND),
    INVALID_EXAM_TYPE(412, "Invalid exam type", HttpStatus.BAD_REQUEST),
    UPDATE_EXAM_FAILED(420, "Update exam failed", HttpStatus.BAD_REQUEST),
    DELETE_EXAM_FAILED(421, "Delete exam failed", HttpStatus.BAD_REQUEST),

    GET_QUESTION_FAILED(442, "Get question failed", HttpStatus.BAD_REQUEST),
    UPDATE_QUESTION_FAILED(440, "Update question failed", HttpStatus.BAD_REQUEST),
    QUESTION_NOT_FOUND(404, "Question not found", HttpStatus.NOT_FOUND),
    MULTIPLE_CORRECT_ANSWERS(441, "One question don't have multi correct answer", HttpStatus.BAD_REQUEST),
    ANSWER_NOT_FOUND(404, "Answer not found", HttpStatus.NOT_FOUND),

    ASSIGNMENT_NOT_FOUND(404, "Assignment not found", HttpStatus.NOT_FOUND),
    STUDENT_ASSIGNMENT_NOT_FOUND(404, "Student assignment not found", HttpStatus.NOT_FOUND),
    DUE_DATE_INVALID(410, "Due date invalid", HttpStatus.BAD_REQUEST),
    ASSIGNMENT_EXISTED(411, "Assignment existed", HttpStatus.BAD_REQUEST),


    UNAUTHENTICATED(400, "Unauthenticated", HttpStatus.UNAUTHORIZED),

    HISTORY_CHATBOT_NOT_FOUND(404, "History chatbot for this user not found", HttpStatus.NOT_FOUND),

    NEWSFEED_NOT_FOUND(404, "Newsfeed not found", HttpStatus.NOT_FOUND),
    POST_COMMENT_FAILED(450, "Post comment failed", HttpStatus.BAD_REQUEST),
    GET_COMMENT_FAILED(451, "Get comment failed", HttpStatus.BAD_REQUEST),
    COMMENT_NOT_FOUND(404, "Comment not found", HttpStatus.NOT_FOUND),
    NOT_COMMENT_BY_USER(453, "Not comment by user", HttpStatus.BAD_REQUEST),
    DELETE_COMMENT_FAILED(452, "Delete comment failed", HttpStatus.BAD_REQUEST),
    ;
    int code;
    String message;
    HttpStatus httpStatus;
}
