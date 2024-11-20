package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.HistoryChatbot;

import java.util.Optional;

public interface HistoryChatbotService {
    Optional<HistoryChatbot> getHistoryChatbotByUserId(Long userId);
}
