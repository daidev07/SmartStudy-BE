package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.ClassroomAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomAssignmentRepository extends JpaRepository<ClassroomAssignment, Long> {

}
