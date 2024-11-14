package com.project.smartstudybejava.entity;

import com.project.smartstudybejava.enumeration.EAssignmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_assignments")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StudentAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    Exam exam;
    @ManyToOne
    User user;
    String description;
    LocalDateTime createdAt;
    @Enumerated
    EAssignmentStatus assignmentStatus;
}
