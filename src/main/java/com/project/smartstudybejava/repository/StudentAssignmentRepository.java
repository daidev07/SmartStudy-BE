package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.StudentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Long> {
     List<StudentAssignment> findByUserId(Long userId);
}
