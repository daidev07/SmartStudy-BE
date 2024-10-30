package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.reqDTO.ChatRequestDTO;
import com.project.smartstudybejava.dto.resDTO.ChatResponseDTO;
import com.project.smartstudybejava.model.TenseModel;
import com.project.smartstudybejava.service.GenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class GenerativeController  {

    private final GenAIService genAIService;

    @PostMapping
    public ChatResponseDTO getChatResponse(@RequestBody ChatRequestDTO chatRequestDTO) {
        return new ChatResponseDTO(genAIService.getChatResponse(chatRequestDTO));
    }

    @PostMapping("/tense")
    public TenseModel getTenseModelFromText(@RequestBody ChatRequestDTO chatRequestDTO) {
        return genAIService.getTenseModelFromText(chatRequestDTO.question());
    }
}
