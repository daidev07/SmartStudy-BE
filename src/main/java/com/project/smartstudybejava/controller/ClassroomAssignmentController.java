package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.AssignmentRequest;
import com.project.smartstudybejava.entity.ClassroomAssignment;
import com.project.smartstudybejava.service.ClassroomAssignmentService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/classroom-assignment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassroomAssignmentController {

    ClassroomAssignmentService classroomAssignmentService;

    @PostMapping("/assign/{classroomId}/{examId}")
    public ResponseData<ClassroomAssignment> assignToClassroom(@PathVariable Long classroomId,
                                                               @PathVariable Long examId,
                                                               @RequestBody AssignmentRequest request) {
        return ResponseData.<ClassroomAssignment>builder()
                .message(SuccessCode.ASSIGN_SUCCESSFUL.getMessage())
                .data(classroomAssignmentService.assignToClassroom(classroomId, examId,
                        request.getName(), request.getDescription(), request.getDueDate(),
                        request.getTotalPoints()))
                .build();
    }

    @GetMapping("/class/{classroomId}")
    public ResponseData<List<ClassroomAssignment>> getListClassroomAssignmentByClassroomId(@PathVariable Long classroomId) {
        return ResponseData.<List<ClassroomAssignment>>builder()
                .message(SuccessCode.GET_ASSIGNMENT_SUCCESSFUL.getMessage())
                .data(classroomAssignmentService.getListClassroomAssignmentByClassroomId(classroomId))
                .build();
    }
}
