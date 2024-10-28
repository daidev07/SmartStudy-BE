package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.reqDTO.ChatRequestDTO;

public interface GenAIService {
    String getChatResponse(ChatRequestDTO chatRequestDTO);
}
