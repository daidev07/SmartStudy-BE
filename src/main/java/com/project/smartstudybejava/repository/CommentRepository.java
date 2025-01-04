package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByNewsFeedId(Long newsFeedId);
}
