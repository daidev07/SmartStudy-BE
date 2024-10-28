package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.reqDTO.ChatRequestDTO;
import com.project.smartstudybejava.service.GenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenAIServiceImpl implements GenAIService {

    @Override
    public String getResponse(ChatRequestDTO chatRequestDTO) {
        return null;
    }
}
