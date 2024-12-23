package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.res.StudentReportResponse;
import com.project.smartstudybejava.entity.AnswerResult;
import com.project.smartstudybejava.entity.StudentAssignment;
import com.project.smartstudybejava.repository.AnswerRepository;
import com.project.smartstudybejava.repository.AnswerResultRepository;
import com.project.smartstudybejava.repository.StudentAssignmentRepository;
import com.project.smartstudybejava.service.StudentReportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentReportServiceImpl implements StudentReportService {

    AnswerResultRepository answerResultRepository;
    StudentAssignmentRepository studentAssignmentRepository;

    @Override
    public StudentReportResponse getReportByUserId(Long userId) {
        List<AnswerResult> answerResults = answerResultRepository.findByUserId(userId);
        List<StudentAssignment> studentAssignments = studentAssignmentRepository.findByUserId(userId);

        return StudentReportResponse.builder()
                .answerResults(answerResults)
                .studentAssignments(studentAssignments)
                .build();
    }
}
