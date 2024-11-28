package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.ClassroomAssignment;

import java.time.LocalDateTime;
import java.util.List;

public interface ClassroomAssignmentService {
    ClassroomAssignment assignToClassroom(Long classroomId, Long examId, String title, String description
                                                    , LocalDateTime dueDate, Long totalPoints);
    List<ClassroomAssignment> getListClassroomAssignmentByClassroomId(Long classroomId);
}
