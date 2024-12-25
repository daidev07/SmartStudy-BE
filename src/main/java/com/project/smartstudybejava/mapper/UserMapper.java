package com.project.smartstudybejava.mapper;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import org.mapstruct.Mapper;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.User;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResDTO toUserResponse(User user);
    User toUserEntity(UserCreationReqDTO userCreationReqDTO);
}
