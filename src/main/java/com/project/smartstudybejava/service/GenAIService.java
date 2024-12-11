package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.entity.HistoryChatbot;
import com.project.smartstudybejava.model.TenseModel;

public interface GenAIService {
    String getResponseExtended(ChatRequestDTO chatRequestDTO);
    String getResponseFromIconAskAI(ChatRequestDTO chatRequestDTO);
}
