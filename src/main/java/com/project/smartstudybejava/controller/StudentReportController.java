package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.res.StudentReportResponse;
import com.project.smartstudybejava.service.StudentReportService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student-report")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentReportController {
    StudentReportService studentReportService;

    @GetMapping("/user/{userId}")
    public ResponseData<StudentReportResponse> getReportByUserId(@PathVariable Long userId) {
        return ResponseData.<StudentReportResponse>builder()
                .message(SuccessCode.GET_REPORT_SUCCESSFUL.getMessage())
                .data(studentReportService.getReportByUserId(userId))
                .build();
    }
}
