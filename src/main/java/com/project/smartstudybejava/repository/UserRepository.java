package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userRoles ur LEFT JOIN FETCH ur.role WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    List<User> findByClassroom(Classroom classroom);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userRoles ur LEFT JOIN FETCH ur.role WHERE ur.role.name = :role")
    List<User> findByRole(@Param("role") String role);

}
