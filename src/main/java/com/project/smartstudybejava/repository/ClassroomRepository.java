package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
