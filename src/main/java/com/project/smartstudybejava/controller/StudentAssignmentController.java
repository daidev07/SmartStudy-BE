package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.entity.StudentAssignment;
import com.project.smartstudybejava.service.StudentAssignmentService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student-assignment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentAssignmentController {

    StudentAssignmentService studentAssignmentService;

    @GetMapping
    public ResponseData<List<StudentAssignment>> getAllAssignments() {
        return ResponseData.<List<StudentAssignment>>builder()
                .code(SuccessCode.GET_ASSIGNMENT_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ASSIGNMENT_SUCCESSFUL.getMessage())
                .data(studentAssignmentService.getAllAssignments())
                .build();
    }

    @GetMapping("/user/{userId}")
    public ResponseData<List<StudentAssignment>> getAssignmentByUserId(@PathVariable Long userId) {
        return ResponseData.<List<StudentAssignment>>builder()
                .code(SuccessCode.GET_ASSIGNMENT_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ASSIGNMENT_SUCCESSFUL.getMessage())
                .data(studentAssignmentService.getAssignmentByUserId(userId))
                .build();
    }
    @GetMapping("/{assignmentId}")
    public ResponseData<StudentAssignment> getAssignmentById(@PathVariable Long assignmentId) {
        return ResponseData.<StudentAssignment>builder()
                .code(SuccessCode.GET_ASSIGNMENT_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ASSIGNMENT_SUCCESSFUL.getMessage())
                .data(studentAssignmentService.getAssignmentById(assignmentId))
                .build();
    }

}
