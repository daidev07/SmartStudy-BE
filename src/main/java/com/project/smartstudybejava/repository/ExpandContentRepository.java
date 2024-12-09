package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.ExpandContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpandContentRepository extends JpaRepository<ExpandContent, Long> {
}
