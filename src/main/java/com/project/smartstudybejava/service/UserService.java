package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import com.project.smartstudybejava.dto.res.UserResDTO;

public interface UserService {
    UserResDTO createUser(UserCreationReqDTO userCreationReqDTO);
}
