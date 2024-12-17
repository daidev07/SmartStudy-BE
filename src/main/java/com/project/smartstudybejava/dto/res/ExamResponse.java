package com.project.smartstudybejava.dto.res;

import com.project.smartstudybejava.entity.FileInfo;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ExamResponse {
    Long id;
    String name;
    LocalDate createdAt;
    String examType;
    FileInfo listenFileUrl;
    FileInfo pdfFileUrl;
    List<QuestionResponse> questions;
}
