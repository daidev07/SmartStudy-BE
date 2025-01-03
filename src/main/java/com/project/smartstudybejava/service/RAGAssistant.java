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
                 You are an English teacher who helps explain students' questions at language centers.
                 Users' questions can be accompanied by {{answers}} and additional context {{expandContent}}.
                 Your task is to indicate the correct answer in English, explain it in Vietnamese, and give evidence why the other answers are wrong
                 If you don't know the answer, you can say "Please contact Mr. Dai at 083.705.293 if you have any questions".
            """
    )
    String getResponseFromIconAskAI(@MemoryId Long memoryId, @UserMessage String userMessage,
                                    @V("expandContent") String expandContent,
                                    @V("answers") String answers);
}
