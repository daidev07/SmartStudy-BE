package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.AnswerResultRequestDTO;
import com.project.smartstudybejava.entity.*;
import com.project.smartstudybejava.enumeration.EAssignmentStatus;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.*;
import com.project.smartstudybejava.service.AnswerResultService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnswerResultServiceImpl implements AnswerResultService {
    AnswerResultRepository answerResultRepository;
    StudentAssignmentRepository studentAssignmentRepository;
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    UserRepository userRepository;

    @Override
    public void saveAnswerResults(List<AnswerResultRequestDTO> answerResults,Long point) {
        for (AnswerResultRequestDTO resultDto : answerResults) {
            AnswerResult answerResult = new AnswerResult();

            StudentAssignment studentAssignment = studentAssignmentRepository.findById(resultDto.getStudentAssignmentId())
                    .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                            ErrorCode.USER_NOT_FOUND.getMessage()));
            Question question = questionRepository.findById(resultDto.getQuestionId())
                    .orElseThrow(() -> new AppException(ErrorCode.QUESTION_NOT_FOUND.getCode(),
                            ErrorCode.QUESTION_NOT_FOUND.getMessage()));
            Answer answer = answerRepository.findById(resultDto.getAnswerId())
                    .orElseThrow(() -> new AppException(ErrorCode.ANSWER_NOT_FOUND.getCode(),
                            ErrorCode.ANSWER_NOT_FOUND.getMessage()));
            User user = userRepository.findById(resultDto.getUserId())
                    .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                            ErrorCode.USER_NOT_FOUND.getMessage()));

            answerResult.setStudentAssignment(studentAssignment);
            answerResult.setQuestion(question);
            answerResult.setAnswer(answer);
            answerResult.setUser(user);

            answerResultRepository.save(answerResult);
        }

        StudentAssignment studentAssignment = studentAssignmentRepository.findById(answerResults.get(0).getStudentAssignmentId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage()));
        studentAssignment.setPoint(point);
        studentAssignment.setAssignmentStatus(EAssignmentStatus.COMPLETED);

        studentAssignmentRepository.save(studentAssignment);
    }
}
