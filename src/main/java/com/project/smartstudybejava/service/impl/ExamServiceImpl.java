package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.ExamRequest;
import com.project.smartstudybejava.dto.res.ExamResponse;
import com.project.smartstudybejava.entity.*;
import com.project.smartstudybejava.enumeration.EExamType;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.AnswerRepository;
import com.project.smartstudybejava.repository.ExamRepository;
import com.project.smartstudybejava.repository.ExpandContentRepository;
import com.project.smartstudybejava.repository.QuestionRepository;
import com.project.smartstudybejava.service.CloudinaryService;
import com.project.smartstudybejava.service.ExamService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
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
    ExpandContentRepository expandContentRepository;

    public Exam createListeningExam(ExamRequest examRequest) throws IOException {
        if(examRepository.existsByName(examRequest.getExamName())) {
            throw new AppException(ErrorCode.EXAM_EXISTED.getCode(), ErrorCode.EXAM_EXISTED.getMessage());
        }

        Exam exam = new Exam();
        exam.setName(examRequest.getExamName());
        exam.setCreatedAt(LocalDate.now());

        FileInfo listenFileUrl = cloudinaryService.saveMp3File(examRequest.getListenMp3File());
        FileInfo pdfFileUrl = cloudinaryService.saveMp3File(examRequest.getListenPdfFile());
        exam.setListenFileUrl(listenFileUrl);
        exam.setPdfFileUrl(pdfFileUrl);
        exam.setExamType(EExamType.LISTENING);
        exam = examRepository.save(exam);
        importListeningQuestionsFromExcel(exam, examRequest.getListenAnswerFile());
        return exam;
    }
    public Exam createReadingExam(ExamRequest examRequest) throws IOException {
        if(examRepository.existsByName(examRequest.getExamName())) {
            throw new AppException(ErrorCode.EXAM_EXISTED.getCode(), ErrorCode.EXAM_EXISTED.getMessage());
        }

        Exam exam = new Exam();
        exam.setName(examRequest.getExamName());
        exam.setCreatedAt(LocalDate.now());

        FileInfo pdfFileUrl = cloudinaryService.saveMp3File(examRequest.getReadingPdfFile());
        exam.setExamType(EExamType.READING);
        exam.setPdfFileUrl(pdfFileUrl);
        exam = examRepository.save(exam);
        importReadingQuestionsFromExcel(exam, examRequest.getReadingAnswerFile());

        return exam;
    }
    public Exam createGrammarExam(ExamRequest examRequest) throws IOException {
        if(examRepository.existsByName(examRequest.getExamName())) {
            throw new AppException(ErrorCode.EXAM_EXISTED.getCode(), ErrorCode.EXAM_EXISTED.getMessage());
        }

        Exam exam = new Exam();
        exam.setName(examRequest.getExamName());
        exam.setCreatedAt(LocalDate.now());
        exam.setExamType(EExamType.GRAMMAR);
        exam = examRepository.save(exam);
        importGrammarQuestionsFromExcel(exam, examRequest.getGrammarFile());

        return exam;
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

    private void importListeningQuestionsFromExcel(Exam exam, MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() < 1) {
                continue;
            }

            int questionNumber = (int) row.getCell(0).getNumericCellValue();
            String questionContent = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "";
            String answer1 = row.getCell(2).getStringCellValue();
            String answer2 = row.getCell(3).getStringCellValue();
            String answer3 = row.getCell(4).getStringCellValue();
            String answer4 = row.getCell(5).getStringCellValue();
            int correctAnswerIndex = (int) row.getCell(6).getNumericCellValue();

            Question question = new Question();
            question.setQuestionNumber(questionNumber);
            question.setContent(questionContent);
            question.setExam(exam);
            questionRepository.save(question);

            createAnswer(answer1, correctAnswerIndex == 2, question);
            createAnswer(answer2, correctAnswerIndex == 3, question);
            createAnswer(answer3, correctAnswerIndex == 4, question);
            createAnswer(answer4, correctAnswerIndex == 5, question);
        }

        workbook.close();
    }
    private void importReadingQuestionsFromExcel(Exam exam, MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        ExpandContent currentExpandContent = null;

        for (Row row : sheet) {
            if (row.getRowNum() < 1) {
                continue;
            }
            Cell expandContentCell = row.getCell(7);
            if (expandContentCell != null) {
                String expandContentText = expandContentCell.getStringCellValue();
                if (!expandContentText.isEmpty()) {
                    ExpandContent expandContent = new ExpandContent();
                    expandContent.setContent(expandContentText);
                    expandContentRepository.save(expandContent);

                    currentExpandContent = expandContent;
                } else {
                    currentExpandContent = null;
                }
            }

            int questionNumber = (int) row.getCell(0).getNumericCellValue();
            String questionContent = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "";
            String answer1 = row.getCell(2).getStringCellValue();
            String answer2 = row.getCell(3).getStringCellValue();
            String answer3 = row.getCell(4).getStringCellValue();
            String answer4 = row.getCell(5).getStringCellValue();
            int correctAnswerIndex = (int) row.getCell(6).getNumericCellValue();

            Question question = new Question();
            question.setExam(exam);
            question.setQuestionNumber(questionNumber);
            question.setContent(questionContent);
            if (currentExpandContent != null) {
                question.setExpandContent(currentExpandContent);
            }
            questionRepository.save(question);

            createAnswer(answer1, correctAnswerIndex == 2, question);
            createAnswer(answer2, correctAnswerIndex == 3, question);
            createAnswer(answer3, correctAnswerIndex == 4, question);
            createAnswer(answer4, correctAnswerIndex == 5, question);
        }

        workbook.close();
    }
    private void importGrammarQuestionsFromExcel(Exam exam, MultipartFile grammarFile) throws IOException {
        InputStream inputStream = grammarFile.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);


        for (Row row : sheet) {
            if (row.getRowNum() < 1) {
                continue;
            }
            int questionNumber = (int) row.getCell(0).getNumericCellValue();
            String questionContent = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "";
            String answer1 = row.getCell(2).getStringCellValue();
            String answer2 = row.getCell(3).getStringCellValue();
            String answer3 = row.getCell(4).getStringCellValue();
            String answer4 = row.getCell(5).getStringCellValue();
            int correctAnswerIndex = (int) row.getCell(6).getNumericCellValue();

            Question question = new Question();
            question.setExam(exam);
            question.setQuestionNumber(questionNumber);
            question.setContent(questionContent);
            questionRepository.save(question);

            createAnswer(answer1, correctAnswerIndex == 2, question);
            createAnswer(answer2, correctAnswerIndex == 3, question);
            createAnswer(answer3, correctAnswerIndex == 4, question);
            createAnswer(answer4, correctAnswerIndex == 5, question);
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
