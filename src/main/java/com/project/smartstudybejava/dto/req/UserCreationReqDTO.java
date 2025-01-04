package com.project.smartstudybejava.dto.req;


import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.enumeration.ERole;
import com.project.smartstudybejava.enumeration.EStudyStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationReqDTO {
    String name;
    String email;
    String phone;
    String username;
    String password;
    Long classroomId;
    EStudyStatus studyStatus;
    ERole role;
}
