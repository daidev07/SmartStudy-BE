package com.project.smartstudybejava.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer_results")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerResult {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    StudentAssignment studentAssignment;
    @ManyToOne
    Question question;
    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = true)
    Answer answer;
    @ManyToOne
    User user;
}
