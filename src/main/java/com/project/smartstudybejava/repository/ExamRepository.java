package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    boolean existsByName(String name);
}
