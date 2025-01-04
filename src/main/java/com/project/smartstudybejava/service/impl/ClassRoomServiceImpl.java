package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.ClassroomRequest;
import com.project.smartstudybejava.dto.res.ClassroomResponse;
import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.enumeration.EClassStatus;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.mapper.ClassroomMapper;
import com.project.smartstudybejava.repository.ClassroomRepository;
import com.project.smartstudybejava.service.ClassRoomService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassRoomServiceImpl implements ClassRoomService {

    ClassroomRepository classroomRepository;
    ClassroomMapper classroomMapper;

    @Override
    public List<Classroom> getAllClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public ClassroomResponse createClassroom(ClassroomRequest classroomRequest) {
        Classroom isClassroomExisted =
                classroomRepository.findByClassName(classroomRequest.getClassName().trim().toLowerCase());
        if (isClassroomExisted != null) {
            throw new AppException(ErrorCode.CLASSROOM_EXISTED.getCode(), ErrorCode.CLASSROOM_EXISTED.getMessage());
        } else {
            Classroom classroom = classroomMapper.toClassroomEntity(classroomRequest);
            classroom.setClassStatus(EClassStatus.PROCESSING);
            Classroom savedClassroom = classroomRepository.save(classroom);
            return classroomMapper.toClassroomResponse(savedClassroom);
        }
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @Override
    public Classroom deleteClassroom(Long id) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if (classroom == null) {
            throw new AppException(ErrorCode.CLASSROOM_NOT_FOUND.getCode(), ErrorCode.CLASSROOM_NOT_FOUND.getMessage());
        }
        classroom.setClassStatus(EClassStatus.DELETED);
        classroomRepository.save(classroom);
        return classroom;
    }
}
