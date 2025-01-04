package com.project.smartstudybejava.entity;


import com.project.smartstudybejava.enumeration.EClassStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classrooms")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Classroom {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String className;
    @Enumerated(EnumType.STRING)
    EClassStatus classStatus;
}
