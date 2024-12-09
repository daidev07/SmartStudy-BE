package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.entity.HistoryChatbot;
import com.project.smartstudybejava.model.TenseModel;

public interface GenAIService {
    TenseModel getTenseModelFromText(String question);
    String getResponseExtended(ChatRequestDTO chatRequestDTO);
    String getResponseFromIconAskAI(ChatRequestDTO chatRequestDTO);
}
