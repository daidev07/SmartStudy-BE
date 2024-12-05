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

import java.time.LocalDate;
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
    LocalDate createdAt;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("exam")
    List<Question> questions;

    @OneToOne(cascade = CascadeType.ALL)
    FileInfo listenFileUrl;
    @OneToOne(cascade = CascadeType.ALL)
    FileInfo pdfFileUrl;
    @Enumerated(EnumType.STRING)
    EExamType examType;

}
