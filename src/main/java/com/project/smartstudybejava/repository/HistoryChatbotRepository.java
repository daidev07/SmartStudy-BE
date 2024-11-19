package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.HistoryChatbot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoryChatbotRepository extends JpaRepository<HistoryChatbot, Long> {
    Optional<HistoryChatbot> findByUserId(Long userId);
}
