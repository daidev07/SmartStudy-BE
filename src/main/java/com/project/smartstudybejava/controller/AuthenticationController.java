package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.AuthenticationRequest;
import com.project.smartstudybejava.dto.res.AuthenticationResponse;
import com.project.smartstudybejava.service.AuthenticationService;
import com.project.smartstudybejava.util.ResponseData;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ResponseData<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        boolean result = authenticationService.authenticate(request);
        return ResponseData.<AuthenticationResponse>builder()
                .data(AuthenticationResponse.builder().authenticated(result).build())
                .build();
    }
}
