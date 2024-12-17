package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.dto.res.ChatResponseDTO;
import com.project.smartstudybejava.entity.HistoryChatbot;
import com.project.smartstudybejava.model.TenseModel;
import com.project.smartstudybejava.service.GenAIService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class GenerativeController  {

    GenAIService genAIService;

    @PostMapping("/ask-ai")
    public ChatResponseDTO getChatResponse(@RequestBody ChatRequestDTO chatRequestDTO) {
        return new ChatResponseDTO(genAIService.getResponseExtended(chatRequestDTO));
    }
    @PostMapping("/quick-ask-ai")
    public ChatResponseDTO getResponseFromIconAskAI(@RequestBody ChatRequestDTO chatRequestDTO) {
        return new ChatResponseDTO(genAIService.getResponseFromIconAskAI(chatRequestDTO));
    }

}
