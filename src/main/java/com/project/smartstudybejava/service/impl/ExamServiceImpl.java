package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.ExamRequest;
import com.project.smartstudybejava.dto.res.ExamResponse;
import com.project.smartstudybejava.entity.Answer;
import com.project.smartstudybejava.entity.Exam;
import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.Question;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.AnswerRepository;
import com.project.smartstudybejava.repository.ExamRepository;
import com.project.smartstudybejava.repository.QuestionRepository;
import com.project.smartstudybejava.service.CloudinaryService;
import com.project.smartstudybejava.service.ExamService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExamServiceImpl implements ExamService {

    ExamRepository examRepository;
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    CloudinaryService cloudinaryService;

    public Exam createExam(ExamRequest examRequest) throws IOException {

        if(examRepository.existsByName(examRequest.getExamName())) {
            throw new AppException(ErrorCode.EXAM_EXISTED.getCode(), ErrorCode.EXAM_EXISTED.getMessage());
        }

        Exam exam = new Exam();
        exam.setName(examRequest.getExamName());
        exam.setCreatedAt(LocalDate.now());
        exam = examRepository.save(exam);

        importQuestionsFromExcel(exam, examRequest.getExamFile());

        if (examRequest.getListenFile() != null && examRequest.getPdfFile() != null) {
            FileInfo listenFileUrl = cloudinaryService.saveFile(examRequest.getListenFile());
            FileInfo pdfFileUrl = cloudinaryService.saveFile(examRequest.getPdfFile());
            exam.setListenFileUrl(listenFileUrl);
            exam.setPdfFileUrl(pdfFileUrl);
        }

        return examRepository.save(exam);
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public ExamResponse getExamByExamId(Long examId) {

        Exam exam = examRepository.findById(examId).orElseThrow(() ->
                new AppException(ErrorCode.EXAM_NOT_FOUND.getCode(), ErrorCode.EXAM_NOT_FOUND.getMessage()));

        ExamResponse examResponse = ExamResponse.builder()
                .id(exam.getId())
                .name(exam.getName())
                .createdAt(exam.getCreatedAt())
                .questions(exam.getQuestions().stream()
                        .map(question -> ExamResponse.QuestionResponse.builder()
                                .id(question.getId())
                                .content(question.getContent())
                                .answers(question.getAnswers().stream()
                                        .map(answer -> ExamResponse.AnswerResponse.builder()
                                                .id(answer.getId())
                                                .content(answer.getContent())
                                                .isCorrect(answer.getIsCorrect())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return examResponse;
    }

    private void importQuestionsFromExcel(Exam exam, MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Đọc dữ liệu từ các cột
            String questionContent = row.getCell(0).getStringCellValue();
            String answer1 = row.getCell(1).getStringCellValue();
            String answer2 = row.getCell(2).getStringCellValue();
            String answer3 = row.getCell(3).getStringCellValue();
            String answer4 = row.getCell(4).getStringCellValue();
            int correctAnswerIndex = (int) row.getCell(5).getNumericCellValue();

            Question question = new Question();
            question.setContent(questionContent);
            question.setExam(exam);
            questionRepository.save(question);

            createAnswer(answer1, correctAnswerIndex == 1, question);
            createAnswer(answer2, correctAnswerIndex == 2, question);
            createAnswer(answer3, correctAnswerIndex == 3, question);
            createAnswer(answer4, correctAnswerIndex == 4, question);
        }

        workbook.close();
    }

    private void createAnswer(String content, boolean isCorrect, Question question) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setIsCorrect(isCorrect);
        answer.setQuestion(question);
        answerRepository.save(answer);
    }
}
