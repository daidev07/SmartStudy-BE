package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.reqDTO.ChatRequestDTO;
import com.project.smartstudybejava.model.TenseModel;

public interface GenAIService {
    String getChatResponse(ChatRequestDTO chatRequestDTO);

    TenseModel getTenseModelFromText(String question);
}
