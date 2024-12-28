package com.project.smartstudybejava.mapper;

import com.project.smartstudybejava.dto.req.ClassroomRequest;
import com.project.smartstudybejava.dto.res.ClassroomResponse;
import com.project.smartstudybejava.entity.Classroom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    @Mapping(target = "className", source = "className")
    Classroom toClassroomEntity(ClassroomRequest classroomRequest);
    ClassroomResponse toClassroomResponse(Classroom classroom);
}
