package com.project.smartstudybejava.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface RAGAssistant {
    @SystemMessage(
            """
                    You are a helpful assistant. Try to respond in a fair and helpful manner.
                    If you don't know answer, you can say "I don't know".
                    """
    )
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
    @SystemMessage(
            """
            You are a helpful chatbot that helps explain questions from students in language centers. 
            The user's question may be accompanied by additional context {{expandContent}} and {{answers}}. 
            Your task is to provide clear, understandable, and helpful answers. 
            Please indicate the correct answer in English and explain it in Vietnamese.
            If you don't know the answer, you can say "I don't know".
            """
    )
    String getResponseFromIconAskAI(@MemoryId Long memoryId, @UserMessage String userMessage,
                                    @V("expandContent") String expandContent,
                                    @V("answers") String answers);
}
