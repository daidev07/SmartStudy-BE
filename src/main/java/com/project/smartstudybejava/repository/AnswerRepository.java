package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.Answer;
import com.project.smartstudybejava.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
