package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.entity.HistoryChatbot;
import com.project.smartstudybejava.entity.MessageDetails;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.HistoryChatbotRepository;
import com.project.smartstudybejava.repository.MessageDetailsRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.project.smartstudybejava.service.Assistant;
import com.project.smartstudybejava.service.GenAIService;
import com.project.smartstudybejava.service.RAGAssistant;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GenAIServiceImpl implements GenAIService {

    Assistant assistant;
    RAGAssistant ragAssistant;
    UserRepository userRepository;
    HistoryChatbotRepository historyChatbotRepository;
    MessageDetailsRepository messageDetailsRepository;

    //    @Override
//    public String getChatResponse(ChatRequestDTO chatRequestDTO) {
//        return assistant.chat(chatRequestDTO.userId(), chatRequestDTO.question());
//    }
//
//    @Override
//    public TenseModel getTenseModelFromText(String question) {
//        return assistant.extractTenseFromText(question);
//    }
//
//    @Override
//    public String getResponseExtended(ChatRequestDTO chatRequestDTO) {
//
//        return assistant.chat(chatRequestDTO.userId(), chatRequestDTO.question());
//    }

    public String getChatResponseSimple(ChatRequestDTO chatRequestDTO) {

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.userMessage(chatRequestDTO.question()));

        var model = OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName(OpenAiChatModelName.GPT_4_O_MINI)
                .build();
        String answerBot = model.generate(messages).content().text();

         userRepository.findById(chatRequestDTO.userId()).orElseThrow(
                    () -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(), ErrorCode.USER_NOT_FOUND.getMessage()));

        HistoryChatbot historyChatbot = historyChatbotRepository.findByUserId(chatRequestDTO.userId())
                .orElseGet(() -> historyChatbotRepository.save(
                        HistoryChatbot.builder()
                                .user(User.builder().id(chatRequestDTO.userId()).build())
                                .title(chatRequestDTO.question())
                                .createdAt(LocalDateTime.now())
                                .build()
                ));

        historyChatbot.setTitle(chatRequestDTO.question());
        historyChatbot.setCreatedAt(LocalDateTime.now());
        historyChatbotRepository.save(historyChatbot);

        messageDetailsRepository.save(MessageDetails.builder()
                .historyChatbot(historyChatbot)
                .messageUser(chatRequestDTO.question())
                .messageBot(answerBot)
                .build());

        return answerBot;
    }

    @Override
    public HistoryChatbot getHistoryChatbotByUserId(Long userId) {
        return historyChatbotRepository.findByUserId(userId).orElseThrow(
                () -> new AppException(ErrorCode.HISTORY_CHATBOT_NOT_FOUND.getCode(),
                        ErrorCode.HISTORY_CHATBOT_NOT_FOUND.getMessage()));
    }
}
