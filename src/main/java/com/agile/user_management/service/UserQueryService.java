package com.agile.user_management.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.agile.user_management.dto.UserDTO;

public interface UserQueryService {
    Page<UserDTO> getAllUsers(Pageable pageable);

    UserDTO getUser(String username);

    Map<String, Map<String, Map<String, Long>>> getUserTree();
}
