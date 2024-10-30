package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.reqDTO.ChatRequestDTO;
import com.project.smartstudybejava.service.GenAIService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenAIServiceImpl implements GenAIService {

    @Value("${openai.api-key}")
    private String apiKey;

    @Override
    public String getChatResponse(ChatRequestDTO chatRequestDTO) {
        var model = OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName(OpenAiChatModelName.GPT_4_O_MINI)
                .build();

        return model.generate(chatRequestDTO.question());
    }
}
