package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.service.ClassRoomService;
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
@RequestMapping("/api/class")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassController {
    ClassRoomService classRoomService;

    @GetMapping
    public ResponseData<List<Classroom>> getAllClasses() {
        return ResponseData.<List<Classroom>>builder()
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(classRoomService.getAllClassroom())
                .build();
    }
    @GetMapping("/{id}")
    public ResponseData<Classroom> getClassById(@PathVariable Long id) {
        return ResponseData.<Classroom>builder()
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(classRoomService.getClassroomById(id))
                .build();
    }
}
