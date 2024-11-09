package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.exception.ResourceNotFoundException;
import com.project.smartstudybejava.mapper.UserMapper;
import com.project.smartstudybejava.repository.ClassroomRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserMapper userMapper;
    UserRepository userRepository;
    ClassroomRepository classroomRepository;

    @Override
    public UserResDTO createUser(UserCreationReqDTO userCreationReqDTO) {
        User user = userMapper.toUserEntity(userCreationReqDTO);

        if (userCreationReqDTO.getClassroomId() != null) {
            Classroom classroom = classroomRepository.findById(Long.valueOf(userCreationReqDTO.getClassroomId()))
                    .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));
            user.setClassroom(classroom);
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
