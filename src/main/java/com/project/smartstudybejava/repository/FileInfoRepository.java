package com.project.smartstudybejava.repository;

import com.project.smartstudybejava.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
}
