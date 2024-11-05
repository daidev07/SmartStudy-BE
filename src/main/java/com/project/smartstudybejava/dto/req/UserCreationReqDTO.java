package com.project.smartstudybejava.dto.req;


import com.project.smartstudybejava.entity.Classroom;
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
    String classroomId;
}
