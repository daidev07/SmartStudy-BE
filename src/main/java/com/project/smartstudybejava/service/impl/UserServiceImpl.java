package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.enumeration.ERole;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.exception.ResourceNotFoundException;
import com.project.smartstudybejava.mapper.UserMapper;
import com.project.smartstudybejava.repository.ClassroomRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.UserService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        if(user.getRole() == ERole.TEACHER) {
            user.setRole(ERole.TEACHER);
        } else if (user.getRole() == ERole.ASSISTANT) {
            user.setRole(ERole.ASSISTANT);
        } else {
            user.setRole(ERole.STUDENT);
            Classroom classroom = classroomRepository.findById(Long.valueOf(userCreationReqDTO.getClassroomId()))
                    .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));
            user.setClassroom(classroom);
        }

        if(!user.getUsername().isEmpty()) {
            String username = user.getUsername();
            if (userRepository.existsByUsername(username)) {
                throw new AppException(ErrorCode.USER_EXISTED.getCode(), ErrorCode.USER_EXISTED.getMessage());
            }
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        user.setCreatedAt(LocalDateTime.now());

        user = userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResDTO getUserByUsername(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage()));
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResDTO> getAllTeachers() {
        List<User> teachers = userRepository.findByRole(ERole.TEACHER);
        return teachers.stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }
    @Override
    public List<UserResDTO> getAllAssistants() {
        List<User> assistants = userRepository.findByRole(ERole.ASSISTANT);
        return assistants.stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResDTO> getAllStudentByClassId(Long classId) {
        List<User> students = userRepository.findAllByClassroomId(classId);
        return students.stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }
}
