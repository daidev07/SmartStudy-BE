package com.project.smartstudybejava.mapper;

import com.project.smartstudybejava.dto.req.UserCreationReqDTO;
import com.project.smartstudybejava.entity.UserRole;
import org.mapstruct.Mapper;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.User;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userRole", expression = "java(getRole(user.getUserRoles()))")
    UserResDTO toUserResponse(User user);
    User toUserEntity(UserCreationReqDTO userCreationReqDTO);

    default String getRole(List<UserRole> userRoles) {
        return userRoles != null && !userRoles.isEmpty() ? userRoles.get(0).getRole().getName() : null;
    }
}
