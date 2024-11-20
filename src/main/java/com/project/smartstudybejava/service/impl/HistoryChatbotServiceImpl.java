package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.HistoryChatbot;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.HistoryChatbotRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.HistoryChatbotService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HistoryChatbotServiceImpl implements HistoryChatbotService {

    HistoryChatbotRepository historyChatbotRepository;

    @Override
    public Optional<HistoryChatbot> getHistoryChatbotByUserId(Long userId) {
        return historyChatbotRepository.findByUserId(userId);
    }
}
