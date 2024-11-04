package com.project.smartstudybejava.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.smartstudybejava.enumeration.EStudyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String avatarUrl;
    String phone;
    String username;
    String password;
    @ManyToOne
    Classroom classroom;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dob;
    @Enumerated
    EStudyStatus studyStatus;

    String createdAt;
    String updatedAt;
    String verificationCode;
    String resetPasswordCode;
    String resetPasswordExpiry;
}
