package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.*;
import com.project.smartstudybejava.enumeration.EAssignmentStatus;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.*;
import com.project.smartstudybejava.service.ClassroomAssignmentService;
import com.project.smartstudybejava.util.ErrorCode;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassroomAssignmentServiceImpl implements ClassroomAssignmentService {

    ClassroomAssignmentRepository classroomAssignmentRepository;
    StudentAssignmentRepository studentAssignmentRepository;
    ClassroomRepository classroomRepository;
    ExamRepository examRepository;
    UserRepository userRepository;

    @Override
    public ClassroomAssignment assignToClassroom(Long classroomId, Long examId, String name, String description
                                                    , LocalDateTime dueDate, Long point) {

        Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(() ->
                new AppException(ErrorCode.CLASSROOM_NOT_FOUND.getCode(), ErrorCode.CLASSROOM_NOT_FOUND.getMessage()));
        Exam exam = examRepository.findById(examId).orElseThrow(() ->
                new AppException(ErrorCode.EXAM_NOT_FOUND.getCode(), ErrorCode.EXAM_NOT_FOUND.getMessage()));

        if(dueDate.isBefore(LocalDateTime.now())) {
            throw new AppException(ErrorCode.DUE_DATE_INVALID.getCode(), ErrorCode.DUE_DATE_INVALID.getMessage());
        }
        if(classroomAssignmentRepository.existsByExamIdAndClassroomId(examId, classroomId)) {
            throw new AppException(ErrorCode.ASSIGNMENT_EXISTED.getCode(), ErrorCode.ASSIGNMENT_EXISTED.getMessage());
        }

        ClassroomAssignment classroomAssignment =  ClassroomAssignment.builder()
                .name(name)
                .exam(exam)
                .classroom(classroom)
                .description(description)
                .assignedAt(LocalDateTime.now())
                .dueDate(dueDate)
                .build();
        classroomAssignment = classroomAssignmentRepository.save(classroomAssignment);

        List<User> students = userRepository.findByClassroom(classroom);
        for (User student : students) {
            StudentAssignment studentAssignment = StudentAssignment.builder()
                    .user(student)
                    .exam(exam)
                    .name(name)
                    .description(description)
                    .assignedAt(LocalDateTime.now())
                    .dueDate(dueDate)
                    .point(point != null ? point : 0L)
                    .assignmentStatus(EAssignmentStatus.NOT_SUBMIT)
                    .build();
            studentAssignmentRepository.save(studentAssignment);
        }
        return ResponseData.<ClassroomAssignment>builder()
                .message(SuccessCode.ASSIGN_SUCCESSFUL.getMessage())
                .data(classroomAssignment)
                .build().getData();

    }

    @Override
    public List<ClassroomAssignment> getListClassroomAssignmentByClassroomId(Long classroomId) {
        classroomRepository.findById(classroomId).orElseThrow(() ->
                new AppException(ErrorCode.CLASSROOM_NOT_FOUND.getCode(), ErrorCode.CLASSROOM_NOT_FOUND.getMessage()));

        return classroomAssignmentRepository.findByClassroomId(classroomId);
    }
}
