package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.model.TenseModel;
import com.project.smartstudybejava.service.Assistant;
import com.project.smartstudybejava.service.GenAIService;
import com.project.smartstudybejava.service.RAGAssistant;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenAIServiceImpl implements GenAIService {

    private final Assistant assistant;
    private final RAGAssistant ragAssistant;

    @Override
    public String getChatResponse(ChatRequestDTO chatRequestDTO) {
        return assistant.chat(chatRequestDTO.userId(), chatRequestDTO.question());
    }

    @Override
    public TenseModel getTenseModelFromText(String question) {
        return assistant.extractTenseFromText(question);
    }

    @Override
    public String getResponseExtended(ChatRequestDTO chatRequestDTO) {

        return ragAssistant.chat(chatRequestDTO.userId(), chatRequestDTO.question());
    }

    public String getChatResponseSimple(ChatRequestDTO chatRequestDTO) {

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.userMessage(chatRequestDTO.question()));

        var model = OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName(OpenAiChatModelName.GPT_3_5_TURBO)
                .build();

        return model.generate(messages).content().text();
    }
}
