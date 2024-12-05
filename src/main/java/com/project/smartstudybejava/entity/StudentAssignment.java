package com.project.smartstudybejava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.smartstudybejava.enumeration.EAssignmentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_assignments")
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StudentAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    @JsonIgnoreProperties("exam")
    Exam exam;
    @ManyToOne
    User user;
    String description;
    LocalDateTime assignedAt;
    LocalDateTime dueDate;
    LocalDateTime submittedAt;
    Long point;
    @Enumerated(EnumType.STRING)
    EAssignmentStatus assignmentStatus;
}
