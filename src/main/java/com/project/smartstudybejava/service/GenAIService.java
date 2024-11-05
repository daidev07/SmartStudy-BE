package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.model.TenseModel;

public interface GenAIService {
    String getChatResponse(ChatRequestDTO chatRequestDTO);

    TenseModel getTenseModelFromText(String question);

    String getResponseExtended(ChatRequestDTO chatRequestDTO);
}
