package com.project.smartstudybejava.service;

import com.nimbusds.jose.JOSEException;
import com.project.smartstudybejava.dto.req.AuthenticationRequest;
import com.project.smartstudybejava.dto.req.IntrospectRequest;
import com.project.smartstudybejava.dto.res.AuthenticationResponse;
import com.project.smartstudybejava.dto.res.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
