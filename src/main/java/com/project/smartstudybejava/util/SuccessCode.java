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

    USER_CREATED_SUCCESSFUL(201, "User created successful" , HttpStatus.CREATED),
    UPDATE_AVATAR_SUCCESSFUL(200, "Update avatar successful" , HttpStatus.OK),
    GET_USER_SUCCESSFUL(200, "Get user successful" , HttpStatus.OK),
    GET_ALL_USER_SUCCESSFUL(200, "Get all user successful" , HttpStatus.OK),
    GET_ALL_TEACHERS_SUCCESSFUL(200, "Get all teachers successful" , HttpStatus.OK),
    GET_ALL_ASSISTANTS_SUCCESSFUL(200, "Get all assistants successful" , HttpStatus.OK),

    DELETE_CLASSROOM_SUCCESSFUL(200, "Delete classroom successful" , HttpStatus.OK),
    CREATE_CLASSROOM_SUCCESSFUL(201, "Created classroom successful" , HttpStatus.CREATED),
    GET_CLASSROOM_SUCCESSFUL(200, "Get classroom successful" , HttpStatus.OK),
    GET_ALL_CLASS_SUCCESSFUL(200, "Get all classroom successful" , HttpStatus.OK),
    GET_ALL_STUDENTS_IN_CLASS_SUCCESSFUL(200, "Get all students in class successful" , HttpStatus.OK),

    GET_EXAM_SUCCESSFUL(200, "Get Exam Successful" , HttpStatus.OK),
    GET_ALL_EXAM_SUCCESSFUL(200, "Get all exam successful" , HttpStatus.OK),
    CREATE_EXAM_SUCCESSFUL(201, "Create exam successful" , HttpStatus.CREATED),
    UPDATE_EXAM_SUCCESSFUL(200, "Update exam successful" , HttpStatus.OK),
    DELETE_EXAM_SUCCESSFUL(200, "Delete exam successful" , HttpStatus.OK),

    GET_QUESTION_SUCCESSFUL(200, "Get question successful" , HttpStatus.OK),
    UPDATE_QUESTION_SUCCESSFUL(200, "Update question successful" , HttpStatus.OK),
    DELETE_QUESTION_SUCCESSFUL(200, "Delete question successful" , HttpStatus.OK),

    GET_ASSIGNMENT_SUCCESSFUL(200, "Get assignment successful" , HttpStatus.OK),
    ASSIGN_SUCCESSFUL(201, "Assignment to classroom successful" , HttpStatus.CREATED),

    POST_SUCCESSFUL(201, "Post successful" , HttpStatus.CREATED),

    GET_REPORT_SUCCESSFUL(200, "Get report successful" , HttpStatus.OK),
    CREATE_REPORT_SUCCESSFUL(201, "Create report successful" , HttpStatus.CREATED),

    GET_HISTORY_CHATBOT_SUCCESSFUL(200, "Get history chatbot successful" , HttpStatus.OK),

    IS_POST_BY_USER(200, "Is post by user successful" , HttpStatus.OK),
    DELETE_POST_SUCCESSFUL(200, "Delete post successful" , HttpStatus.OK),
    PERMIT_POST_SUCCESSFUL(200, "Permit post successful" , HttpStatus.OK),
    POST_COMMENT_SUCCESSFUL(201, "Post comment successful" , HttpStatus.CREATED),
    GET_COMMENT_SUCCESSFUL(200, "Get comment successful" , HttpStatus.OK),
    IS_COMMENT_BY_USER(200, "Is comment by user successful" , HttpStatus.OK),
    DELETE_COMMENT_SUCCESSFUL(200, "Delete comment successful" , HttpStatus.OK),
    ;

    int code;
    String message;
    HttpStatus httpStatus;
}
