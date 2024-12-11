package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.ChatRequestDTO;
import com.project.smartstudybejava.entity.HistoryChatbot;
import com.project.smartstudybejava.entity.MessageDetails;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.model.TenseModel;
import com.project.smartstudybejava.repository.HistoryChatbotRepository;
import com.project.smartstudybejava.repository.MessageDetailsRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import com.project.smartstudybejava.service.Assistant;
import com.project.smartstudybejava.service.GenAIService;
import com.project.smartstudybejava.service.RAGAssistant;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
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

    @Override
    public String getResponseExtended(ChatRequestDTO chatRequestDTO) {
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.userMessage(chatRequestDTO.getQuestion()));
//        var model = OpenAiChatModel.builder()
//                .apiKey("demo")
//                .modelName(OpenAiChatModelName.GPT_4_O_MINI)
//                .build();
//        String answerBot = model.generate(messages).content().text();
        String answerBot = ragAssistant.chat(chatRequestDTO.getUserId(), chatRequestDTO.getQuestion());

        userRepository.findById(chatRequestDTO.getUserId()).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(), ErrorCode.USER_NOT_FOUND.getMessage()));

        HistoryChatbot historyChatbot = historyChatbotRepository.findByUserId(chatRequestDTO.getUserId())
                .orElseGet(() -> historyChatbotRepository.save(
                        HistoryChatbot.builder()
                                .user(User.builder().id(chatRequestDTO.getUserId()).build())
                                .build()
                ));

        String title = chatRequestDTO.getQuestion();
        if (title.length() > 100) {
            title = title.substring(0, 100) + "...";
        }
        historyChatbot.setTitle(title);
        historyChatbot.setCreatedAt(LocalDateTime.now());
        historyChatbotRepository.save(historyChatbot);

        messageDetailsRepository.save(MessageDetails.builder()
                .historyChatbot(historyChatbot)
                .messageUser(chatRequestDTO.getQuestion())
                .messageBot(answerBot)
                .respondedAt(LocalDateTime.now())
                .build());

        return answerBot;
    }
    @Override
    public String getResponseFromIconAskAI(ChatRequestDTO chatRequestDTO) {
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.userMessage(chatRequestDTO.getQuestion()));
        String answerBot = ragAssistant.getResponseFromIconAskAI(
                chatRequestDTO.getUserId(), chatRequestDTO.getQuestion(),
                chatRequestDTO.getExpandContent(), chatRequestDTO.getAnswers());

        userRepository.findById(chatRequestDTO.getUserId()).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(), ErrorCode.USER_NOT_FOUND.getMessage()));

        HistoryChatbot historyChatbot = historyChatbotRepository.findByUserId(chatRequestDTO.getUserId())
                .orElseGet(() -> historyChatbotRepository.save(
                        HistoryChatbot.builder()
                                .user(User.builder().id(chatRequestDTO.getUserId()).build())
                                .build()
                ));

        String title = chatRequestDTO.getQuestion();
        if (title.length() > 100) {
            title = title.substring(0, 100) + "...";
        }
        historyChatbot.setTitle(title);
        historyChatbot.setCreatedAt(LocalDateTime.now());
        historyChatbotRepository.save(historyChatbot);

        messageDetailsRepository.save(MessageDetails.builder()
                .historyChatbot(historyChatbot)
                .messageUser(chatRequestDTO.getQuestion())
                .messageBot(answerBot)
                .respondedAt(LocalDateTime.now())
                .build());

        return answerBot;
    }
}
