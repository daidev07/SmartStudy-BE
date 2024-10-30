package com.project.smartstudybejava.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface Assistant {

    @SystemMessage(
            """
                    You are a helpful assistant. Try to respond in a fair and helpful manner.
                    If you don't know answer, you can say "I don't know".
                    """
    )
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

}
