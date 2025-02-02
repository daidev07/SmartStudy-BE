package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.ClassroomAssignment;
import com.project.smartstudybejava.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomAssignmentRepository extends JpaRepository<ClassroomAssignment, Long> {

    List<ClassroomAssignment> findByClassroomId(Long classroomId);
    boolean existsByExamIdAndClassroomId(Long examId, Long classroomId);
}
