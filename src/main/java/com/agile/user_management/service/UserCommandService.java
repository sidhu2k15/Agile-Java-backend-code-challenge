package com.agile.user_management.service;

import java.util.List;

import com.agile.user_management.dto.UserDTO;

public interface UserCommandService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String username, UserDTO userDTO);

    void deleteUser(String username);

    List<UserDTO> generateRandomUsers(int number);
}
