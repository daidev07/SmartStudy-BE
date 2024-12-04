package com.project.smartstudybejava.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
