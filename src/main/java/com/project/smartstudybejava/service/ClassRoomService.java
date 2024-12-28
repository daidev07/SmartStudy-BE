package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.ClassroomRequest;
import com.project.smartstudybejava.dto.res.ClassroomResponse;
import com.project.smartstudybejava.entity.Classroom;

import java.util.List;

public interface ClassRoomService {
    List<Classroom> getAllClassroom();
    ClassroomResponse createClassroom(ClassroomRequest classroomRequest);
    Classroom getClassroomById(Long id);
}
