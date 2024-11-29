package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.NewFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewFeedRepository extends JpaRepository<NewFeed, Long> {

    List<NewFeed> findByClassroomId(Long classId);
}
