package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.AuthenticationRequest;
import com.project.smartstudybejava.dto.res.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
