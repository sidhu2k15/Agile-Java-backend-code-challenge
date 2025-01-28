package com.agile.user_management.service.impl;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.agile.user_management.dto.UserDTO;
import com.agile.user_management.entity.User;
import com.agile.user_management.mapper.UserMapper;
import com.agile.user_management.repository.UserRepository;
import com.agile.user_management.service.UserQueryService;
import com.agile.user_management.exception.ResourceNotFoundException;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDTO);
    }

    @Override
    public UserDTO getUser(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public Map<String, Map<String, Map<String, Long>>> getUserTree() {
        return userRepository.findAll().stream()
                .collect(Collectors.groupingBy(User::getCountry,
                        Collectors.groupingBy(User::getState,
                                Collectors.groupingBy(User::getCity, Collectors.counting()))));
    }
}
