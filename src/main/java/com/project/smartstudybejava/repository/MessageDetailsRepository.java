package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.MessageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDetailsRepository extends JpaRepository<MessageDetails, Long> {
}
