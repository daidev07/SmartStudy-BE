package com.project.smartstudybejava.dto.res;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.enumeration.ERole;
import com.project.smartstudybejava.enumeration.EStudyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResDTO {
    Long id;
    String name;
    String email;
    String avatarUrl;
    String phone;
    String username;
    Classroom classroom;
    LocalDate dob;
    EStudyStatus studyStatus;
    ERole role;
}
