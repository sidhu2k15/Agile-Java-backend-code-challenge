package com.agile.user_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.user_management.dto.UserDTO;
import com.agile.user_management.model.Response;
import com.agile.user_management.service.UserCommandService;
import com.agile.user_management.service.UserQueryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/users")
public class UserManagementController {

	@Autowired
	private UserCommandService userCommandService;

	@Autowired
	private UserQueryService userQueryService;

	@GetMapping
	@Operation(summary = "Get all users")
	public ResponseEntity<Response<Page<UserDTO>>> getAllUsers(Pageable pageable) {
		Page<UserDTO> pg = userQueryService.getAllUsers(pageable);
		Response<Page<UserDTO>> response = new Response<>(true, "success", "Get all users successful", pg);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{username}")
	@Operation(summary = "Get a single user by username")
	public ResponseEntity<Response<UserDTO>> getUser(@PathVariable String username) {
		UserDTO userDTO = userQueryService.getUser(username);
		Response<UserDTO> response = new Response<>(true, "success", "Retrieved user by username successful", userDTO);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	@Operation(summary = "Create a new user")
	public ResponseEntity<Response<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
		UserDTO user = userCommandService.createUser(userDTO);
		Response<UserDTO> response = new Response<>(true, "success", "Created user successfully", user);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{username}")
	@Operation(summary = "Update a user's details")
	public ResponseEntity<Response<UserDTO>> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
		UserDTO user = userCommandService.updateUser(username, userDTO);
		Response<UserDTO> response = new Response<>(true, "success", "Update successfull", user);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{username}")
	@Operation(summary = "Delete a user")
	public void deleteUser(@PathVariable String username) {
		userCommandService.deleteUser(username);
	}

	@GetMapping("/generate/{number}")
	@Operation(summary = "Generate random users")
	public ResponseEntity<Response<List<UserDTO>>> generateRandomUsers(@PathVariable int number) {
		List<UserDTO> userDtosList = userCommandService.generateRandomUsers(number);
		Response<List<UserDTO>> response = new Response<>(true, "success", "Generated random users successfully", userDtosList);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/tree")
	@Operation(summary = "Get users grouped by country, state, and city")
	public ResponseEntity<Response<Map<String, Map<String, Map<String, Long>>>>> getUserTree() {
		Map<String, Map<String, Map<String, Long>>> userTree = userQueryService.getUserTree();
		Response<Map<String, Map<String, Map<String, Long>>>> response = new Response<>(true, "success",
				"Get users grouped by country, state, and city successful", userTree);
		return ResponseEntity.ok(response);
	}
}
