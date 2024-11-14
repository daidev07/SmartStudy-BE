package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.repository.ClassroomRepository;
import com.project.smartstudybejava.service.ClassRoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getAllClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }
}
