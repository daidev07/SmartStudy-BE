package com.project.smartstudybejava.mapper;

import com.project.smartstudybejava.dto.res.AnswerResultResponseDTO;
import com.project.smartstudybejava.entity.AnswerResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerResultMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "studentAssignment.id", target = "studentAssignmentId")
    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "answer.id", target = "answerId")
    AnswerResultResponseDTO toDto(AnswerResult answerResult);


    List<AnswerResultResponseDTO> toDtoList(List<AnswerResult> answerResults);
}
