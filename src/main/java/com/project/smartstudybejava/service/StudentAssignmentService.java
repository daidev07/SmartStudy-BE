package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.StudentAssignment;

import java.util.List;

public interface StudentAssignmentService {
    List<StudentAssignment> getAllAssignments();
    List<StudentAssignment> getAssignmentByUserId(Long userId);
    StudentAssignment getAssignmentById(Long assignmentId);
}
