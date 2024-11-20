package com.project.smartstudybejava.service;

import com.project.smartstudybejava.model.TenseModel;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface Assistant {

    @SystemMessage(
            """
                    You are a helpful assistant. Try to respond in a fair and helpful manner.
                    If you don't know answer, you can say "I don't know".
                    """
    )
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

    @SystemMessage("Extract information about tenses from {{text}} in json object format.")
    @UserMessage("Please extract tense information from the provided text.")
    TenseModel extractTenseFromText( @V("text") String text);

}
