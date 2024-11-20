package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.entity.HistoryChatbot;
import com.project.smartstudybejava.service.HistoryChatbotService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/history-chatbot")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HistoryChatbotController {

    HistoryChatbotService historyChatbotService;

    @GetMapping("/user/{userId}")
    public ResponseData<Optional<HistoryChatbot>> getHistoryChatbotByUserId(@PathVariable Long userId) {
        return ResponseData.<Optional<HistoryChatbot>>builder()
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(historyChatbotService.getHistoryChatbotByUserId(userId))
                .build();
    }
}
