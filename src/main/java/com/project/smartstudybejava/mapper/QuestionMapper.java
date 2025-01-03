package com.project.smartstudybejava.mapper;

import com.project.smartstudybejava.dto.res.QuestionResponse;
import com.project.smartstudybejava.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionResponse toQuestionResponse(Question question);
    Question toQuestionEntity(QuestionResponse questionResponse);
}
