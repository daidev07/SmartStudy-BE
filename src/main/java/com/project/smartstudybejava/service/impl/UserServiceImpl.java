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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public UserResDTO createUser(UserCreationReqDTO userCreationReqDTO) {
        User user = userMapper.toUserEntity(userCreationReqDTO);

        // Lấy Classroom từ database theo ID
        if (userCreationReqDTO.getClassroomId() != null) {
            Classroom classroom = classroomRepository.findById(Long.valueOf(userCreationReqDTO.getClassroomId()))
                    .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));
            user.setClassroom(classroom);
        }

        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
