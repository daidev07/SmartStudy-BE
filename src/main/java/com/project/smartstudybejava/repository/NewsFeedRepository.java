package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {
}
