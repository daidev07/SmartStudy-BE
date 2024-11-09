package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.AuthenticationRequest;
import com.project.smartstudybejava.exception.BadRequestException;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.AuthenticationService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    UserRepository userRepository;

    public boolean authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadRequestException(ErrorCode.USER_NOT_FOUND.getCode(),
                                                            ErrorCode.USER_NOT_FOUND.getMessage()));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
