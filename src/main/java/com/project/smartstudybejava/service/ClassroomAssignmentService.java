package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.ClassroomAssignment;

public interface ClassroomAssignmentService {
    ClassroomAssignment assignToClassroom(Long classroomId, Long examId, String title, String description);
}
