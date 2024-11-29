package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.Classroom;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    @NotNull
    List<Classroom> findAll();
}
