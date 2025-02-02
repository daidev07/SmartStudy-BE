package com.project.smartstudybejava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.smartstudybejava.enumeration.EExamType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exams")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Exam {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDateTime createdAt;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("exam")
    List<Question> questions;

    @OneToOne(cascade = CascadeType.ALL)
    FileInfo listenFile;
    @OneToOne(cascade = CascadeType.ALL)
    FileInfo pdfFile;
    @Enumerated(EnumType.STRING)
    EExamType examType;

}
