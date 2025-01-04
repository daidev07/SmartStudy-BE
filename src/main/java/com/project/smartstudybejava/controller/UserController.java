package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.service.UserService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    public ResponseData<UserResDTO> createUser(@RequestBody UserCreationReqDTO userCreationReqDTO) {
        return ResponseData.<UserResDTO>builder()
                .code(SuccessCode.USER_CREATED_SUCCESSFUL.getCode())
                .message(SuccessCode.USER_CREATED_SUCCESSFUL.getMessage())
                .data(userService.createUser(userCreationReqDTO))
                .build();
    }
    @GetMapping
    public ResponseData<List<UserResDTO>> getAllUsers() {
        return ResponseData.<List<UserResDTO>>builder()
                .code(SuccessCode.GET_ALL_USER_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ALL_USER_SUCCESSFUL.getMessage())
                .data(userService.getAllUsers())
                .build();
    }
    @GetMapping("/{userName}")
    public ResponseData<UserResDTO> getUserByUsername(@PathVariable String userName) {
        return ResponseData.<UserResDTO>builder()
                .code(SuccessCode.GET_USER_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_USER_SUCCESSFUL.getMessage())
                .data(userService.getUserByUsername(userName))
                .build();
    }
    @GetMapping("/teachers")
    public ResponseData<List<UserResDTO>> getAllTeachers() {
        return ResponseData.<List<UserResDTO>>builder()
                .code(SuccessCode.GET_ALL_TEACHERS_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ALL_TEACHERS_SUCCESSFUL.getMessage())
                .data(userService.getAllTeachers())
                .build();
    }
    @GetMapping("/assistants")
    public ResponseData<List<UserResDTO>> getAllAssistants() {
        return ResponseData.<List<UserResDTO>>builder()
                .code(SuccessCode.GET_ALL_ASSISTANTS_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ALL_ASSISTANTS_SUCCESSFUL.getMessage())
                .data(userService.getAllAssistants())
                .build();
    }
    @GetMapping("/get-all-by-classId/{classId}")
    public ResponseData<List<UserResDTO>> getAllStudentByClassId(@PathVariable Long classId) {
        return ResponseData.<List<UserResDTO>>builder()
                .code(SuccessCode.GET_ALL_STUDENTS_IN_CLASS_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_ALL_STUDENTS_IN_CLASS_SUCCESSFUL.getMessage())
                .data(userService.getAllStudentByClassId(classId))
                .build();
    }
}
