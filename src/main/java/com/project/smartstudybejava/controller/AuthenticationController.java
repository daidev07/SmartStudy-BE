package com.project.smartstudybejava.controller;

import com.nimbusds.jose.JOSEException;
import com.project.smartstudybejava.dto.req.AuthenticationRequest;
import com.project.smartstudybejava.dto.req.IntrospectRequest;
import com.project.smartstudybejava.dto.res.AuthenticationResponse;
import com.project.smartstudybejava.dto.res.IntrospectResponse;
import com.project.smartstudybejava.service.AuthenticationService;
import com.project.smartstudybejava.util.ResponseData;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ResponseData<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var result = authenticationService.authenticate(request);
        return ResponseData.<AuthenticationResponse>builder()
                .data(result)
                .build();
    }

    @PostMapping("/introspect")
    ResponseData<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ResponseData.<IntrospectResponse>builder()
                .data(result)
                .build();
    }
}
