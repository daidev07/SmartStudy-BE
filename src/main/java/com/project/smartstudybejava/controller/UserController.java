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
                .message(SuccessCode.CREATED.getMessage())
                .data(userService.createUser(userCreationReqDTO))
                .build();
    }
    @GetMapping
    public ResponseData<List<User>> getAllUsers() {
        return ResponseData.<List<User>>builder()
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(userService.getAllUsers())
                .build();
    }
    @GetMapping("/{userName}")
    public ResponseData<UserResDTO> getUserByUsername(@PathVariable String userName) {
        return ResponseData.<UserResDTO>builder()
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(userService.getUserByUsername(userName))
                .build();
    }

}
