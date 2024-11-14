package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.Classroom;

import java.util.List;

public interface ClassRoomService {
    List<Classroom> getAllClassroom();

    Classroom getClassroomById(Long id);
}
