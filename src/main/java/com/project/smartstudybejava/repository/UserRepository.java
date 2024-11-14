package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByClassroom(Classroom classroom);
}
