package com.project.smartstudybejava.entity;

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
@Table(name = "classroom_assignments")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ClassroomAssignment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    Exam exam;
    @ManyToOne
    Classroom classroom;
    String description;
    LocalDateTime assignedAt;
    LocalDateTime dueDate;
}
