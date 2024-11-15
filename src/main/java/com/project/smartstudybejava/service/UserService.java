package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.User;

import java.util.List;

public interface UserService {
    UserResDTO createUser(UserCreationReqDTO userCreationReqDTO);
    List<User> getAllUsers();

    User getUserByUsername(String userName);
}
