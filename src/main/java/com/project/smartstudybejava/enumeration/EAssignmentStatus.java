package com.project.smartstudybejava.enumeration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum EAssignmentStatus {
    SUBMITTED("Submitted"),
    LATE_SUBMISSION("Late Submission"),
    NOT_SUBMIT("Not Submit");

    String name;
}
