package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.dto.res.ChatResponseDTO;
import com.project.smartstudybejava.model.TenseModel;
import com.project.smartstudybejava.service.GenAIService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class GenerativeController  {

    GenAIService genAIService;

    @PostMapping("/ask-ai")
    public ChatResponseDTO getChatResponse(@RequestBody ChatRequestDTO chatRequestDTO) {
        return new ChatResponseDTO(genAIService.getChatResponseSimple(chatRequestDTO));
    }
//    @PostMapping("/extended")
//    public ChatResponseDTO getChatResponseExtended(@RequestBody ChatRequestDTO chatRequestDTO) {
//        return new ChatResponseDTO(genAIService.getResponseExtended(chatRequestDTO));
//    }
//
//    @PostMapping("/tense")
//    public TenseModel getTenseModelFromText(@RequestBody ChatRequestDTO chatRequestDTO) {
//        return genAIService.getTenseModelFromText(chatRequestDTO.question());
//    }
}
