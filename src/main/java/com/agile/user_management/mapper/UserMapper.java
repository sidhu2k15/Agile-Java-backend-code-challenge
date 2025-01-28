package com.agile.user_management.mapper;

import org.springframework.stereotype.Component;

import com.agile.user_management.dto.UserDTO;
import com.agile.user_management.entity.User;

@Component
public class UserMapper {
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setGender(dto.getGender());
        user.setPictureUrl(dto.getPictureUrl());
        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setPictureUrl(user.getPictureUrl());
        return dto;
    }
}
