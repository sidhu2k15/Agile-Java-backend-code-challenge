package com.agile.user_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.user_management.dto.UserDTO;
import com.agile.user_management.service.UserCommandService;
import com.agile.user_management.service.UserQueryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/users")
public class UserManagementController {

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserQueryService userQueryService;

    @GetMapping
    @Operation(summary = "Get all users")
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userQueryService.getAllUsers(pageable);
    }

    @GetMapping("/{username}")
    @Operation(summary = "Get a single user by username")
    public UserDTO getUser(@PathVariable String username) {
        return userQueryService.getUser(username);
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userCommandService.createUser(userDTO);
    }

    @PutMapping("/{username}")
    @Operation(summary = "Update a user's details")
    public UserDTO updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
        return userCommandService.updateUser(username, userDTO);
    }

    @DeleteMapping("/{username}")
    @Operation(summary = "Delete a user")
    public void deleteUser(@PathVariable String username) {
        userCommandService.deleteUser(username);
    }

    @GetMapping("/generate/{number}")
    @Operation(summary = "Generate random users")
	public List<UserDTO> generateRandomUsers(@PathVariable int number) {
        return userCommandService.generateRandomUsers(number);
    }

    @GetMapping("/tree")
    @Operation(summary = "Get users grouped by country, state, and city")
    public Map<String, Map<String, Map<String, Long>>> getUserTree() {
        return userQueryService.getUserTree();
    }
}
