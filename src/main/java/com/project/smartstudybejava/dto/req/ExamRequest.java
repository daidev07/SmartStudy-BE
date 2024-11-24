package com.project.smartstudybejava.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = lombok.AccessLevel.PRIVATE)
public class ExamRequest {
    String examName;
    MultipartFile examFile;
    MultipartFile listenFile;
    MultipartFile pdfFile;
}