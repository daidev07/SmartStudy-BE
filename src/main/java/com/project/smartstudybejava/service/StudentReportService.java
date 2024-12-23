package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.res.StudentReportResponse;

public interface StudentReportService {
    StudentReportResponse getReportByUserId(Long userId);
}
