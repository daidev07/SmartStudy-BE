package com.project.smartstudybejava.enumeration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum EStudyStatus {
    IN_PROGRESS("In Progress"),
    PENDING("Pending"),
    QUIT("Quit"),
    COMPLETED("Completed");

    String name;

}
