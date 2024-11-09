package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.AuthenticationRequest;

public interface AuthenticationService {
    boolean authenticate(AuthenticationRequest request);
}
