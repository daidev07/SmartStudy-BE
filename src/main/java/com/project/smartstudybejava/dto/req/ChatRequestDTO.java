package com.project.smartstudybejava.dto.req;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ChatRequestDTO {
    Long userId;
    String question;
    String expandContent;
    String answers;
}
