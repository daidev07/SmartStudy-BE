package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.FileInfo;

import java.util.List;

public interface UserService {
    UserResDTO createUser(UserCreationReqDTO userCreationReqDTO);
    List<UserResDTO> getAllUsers();
    UserResDTO getUserByUsername(String userName);
    List<UserResDTO> getAllTeachers();
    List<UserResDTO> getAllAssistants();
    List<UserResDTO> getAllStudentByClassId(Long classId);
    UserResDTO updateAvatar(Long userId, FileInfo avatar);
}
