package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.reqDTO.ChatRequestDTO;
import com.project.smartstudybejava.model.TenseModel;
import com.project.smartstudybejava.service.Assistant;
import com.project.smartstudybejava.service.GenAIService;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenAIServiceImpl implements GenAIService {

    private final Assistant assistant;

    @Override
    public String getChatResponse(ChatRequestDTO chatRequestDTO) {
        return assistant.chat(chatRequestDTO.userId(), chatRequestDTO.question());
    }

    @Override
    public TenseModel getTenseModelFromText(String question) {
        return assistant.extractTenseFromText(question);
    }

    public String getChatResponseSimple(ChatRequestDTO chatRequestDTO) {

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.userMessage(chatRequestDTO.question()));

        var model = OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName(OpenAiChatModelName.GPT_4_O_MINI)
                .build();

        return model.generate(messages).content().text();
    }
}
