package com.project.smartstudybejava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Question {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    Exam exam;
    String content;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    List<Answer> answers;
}
