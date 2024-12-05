package com.project.smartstudybejava.enumeration;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum EExamType {
    LISTENING ("Listening"),
    READING ("Reading"),
    WRITING ("Writing"),
    SPEAKING ("Speaking"),
    GRAMMAR("Grammar");

    String name;
}
