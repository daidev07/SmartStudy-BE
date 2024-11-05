package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
