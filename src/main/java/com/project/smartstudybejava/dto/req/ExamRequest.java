package com.project.smartstudybejava.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = lombok.AccessLevel.PRIVATE)
public class ExamRequest {
    String examName;
    MultipartFile grammarFile;
    MultipartFile listenMp3File;
    MultipartFile listenPdfFile;
    MultipartFile listenAnswerFile;
    MultipartFile readingPdfFile;
    MultipartFile readingAnswerFile;
    String examType;
}