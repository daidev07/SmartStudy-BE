package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.Answer;
import com.project.smartstudybejava.entity.Exam;
import com.project.smartstudybejava.entity.Question;
import com.project.smartstudybejava.repository.AnswerRepository;
import com.project.smartstudybejava.repository.ExamRepository;
import com.project.smartstudybejava.repository.QuestionRepository;
import com.project.smartstudybejava.service.ExamService;
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
import java.util.Iterator;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExamServiceImpl implements ExamService {

    ExamRepository examRepository;
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;

    public void createExamWithQuestions(String examName, MultipartFile file) throws IOException {
        // Tạo đề thi mới
        Exam exam = new Exam();
        exam.setName(examName);  // Đặt tên cho đề thi
        exam = examRepository.save(exam);  // Lưu đề thi vào CSDL

        // Đọc và import câu hỏi từ file Excel
        importQuestionsFromExcel(exam, file);
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

            // Tạo câu hỏi
            Question question = new Question();
            question.setContent(questionContent);
            question.setExam(exam);
            questionRepository.save(question);

            // Tạo các câu trả lời
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
