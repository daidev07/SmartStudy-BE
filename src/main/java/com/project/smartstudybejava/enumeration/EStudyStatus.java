package com.project.smartstudybejava.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PUBLIC)
public enum EStudyStatus {
    IN_PROGRESS,
    PENDING,
    QUIT,
    COMPLETED
}
