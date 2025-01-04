package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.StudentAssignment;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.StudentAssignmentRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.StudentAssignmentService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentAssignmentServiceImpl implements StudentAssignmentService {

    StudentAssignmentRepository studentAssignmentRepository;
    UserRepository userRepository;

    @Override
    public List<StudentAssignment> getAllAssignments() {
        return studentAssignmentRepository.findAll();
    }

    @Override
    public List<StudentAssignment> getAssignmentByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new AppException(ErrorCode.USER_NOT_FOUND.getCode(), ErrorCode.USER_NOT_FOUND.getMessage());
        }
        return studentAssignmentRepository.findByUserId(userId);
    }

    @Override
    public StudentAssignment getAssignmentById(Long assignmentId) {
        return studentAssignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new AppException(ErrorCode.ASSIGNMENT_NOT_FOUND.getCode(),
                        ErrorCode.ASSIGNMENT_NOT_FOUND.getMessage()));
    }
}
