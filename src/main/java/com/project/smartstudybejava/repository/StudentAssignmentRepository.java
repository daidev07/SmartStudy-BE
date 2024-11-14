package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.StudentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Long> {
}
