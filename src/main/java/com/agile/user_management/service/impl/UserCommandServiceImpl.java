package com.agile.user_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.user_management.dto.UserDTO;
import com.agile.user_management.entity.User;
import com.agile.user_management.exception.ResourceNotFoundException;
import com.agile.user_management.mapper.UserMapper;
import com.agile.user_management.repository.UserRepository;
import com.agile.user_management.service.UserCommandService;
import com.agile.user_management.util.RandomUserGenerator;

@Service
public class UserCommandServiceImpl implements UserCommandService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RandomUserGenerator randomUserGenerator;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = userMapper.toEntity(userDTO);
		return userMapper.toDTO(userRepository.save(user));
	}

	@Override
	public UserDTO updateUser(String username, UserDTO userDTO) {
		User user = userRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setGender(userDTO.getGender());
		user.setPictureUrl(userDTO.getPictureUrl());
		return userMapper.toDTO(userRepository.save(user));
	}

	@Override
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}

	@Override
	public List<UserDTO> generateRandomUsers(int number) {

		return randomUserGenerator.fetchRandomUsers(number).stream().map(usrrr -> {
			userRepository.save(usrrr);

			return userMapper.toDTO(usrrr);
		}).collect(Collectors.toList());

	}
}
