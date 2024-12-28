package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.ClassroomRequest;
import com.project.smartstudybejava.dto.res.ClassroomResponse;
import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.service.ClassRoomService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/class")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassController {
    ClassRoomService classRoomService;

    @GetMapping
    public ResponseData<List<Classroom>> getAllClasses() {
        return ResponseData.<List<Classroom>>builder()
                .code(SuccessCode.GET_ALL_CLASS_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ALL_CLASS_SUCCESSFUL.getMessage())
                .data(classRoomService.getAllClassroom())
                .build();
    }
    @GetMapping("/{id}")
    public ResponseData<Classroom> getClassById(@PathVariable Long id) {
        return ResponseData.<Classroom>builder()
                .code(SuccessCode.GET_CLASSROOM_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_CLASSROOM_SUCCESSFUL.getMessage())
                .data(classRoomService.getClassroomById(id))
                .build();
    }
    @PostMapping()
    public ResponseData<ClassroomResponse> createClass(@RequestBody ClassroomRequest classroomRequest) {
        return ResponseData.<ClassroomResponse>builder()
                .code(SuccessCode.CREATE_CLASSROOM_SUCCESSFUL.getCode())
                .message(SuccessCode.CREATE_CLASSROOM_SUCCESSFUL.getMessage())
                .data(classRoomService.createClassroom(classroomRequest))
                .build();
    }
}
