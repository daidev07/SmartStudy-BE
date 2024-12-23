package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.dto.res.AnswerResultResponseDTO;
import com.project.smartstudybejava.entity.AnswerResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerResultRepository extends JpaRepository<AnswerResult, Long> {
    List<AnswerResult> findByUserIdAndStudentAssignmentId(Long userId, Long studentAssignmentId);
    List<AnswerResult> findByUserId(Long userId);
}
