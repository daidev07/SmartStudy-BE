package com.project.smartstudybejava.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.smartstudybejava.enumeration.EStudyStatus;
import dev.langchain4j.data.message.ToolExecutionResultMessage;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(unique = true)
    String email;
    String avatarUrl;
    String phone;
    @Column(unique = true)
    String username;
    String password;
    @ManyToOne
    Classroom classroom;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dob;
    @Enumerated(EnumType.STRING)
    EStudyStatus studyStatus;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String verificationCode;
    String resetPasswordCode;
    String resetPasswordExpiry;
}
