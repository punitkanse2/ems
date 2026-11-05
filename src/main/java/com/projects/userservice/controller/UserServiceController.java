package com.projects.userservice.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.userservice.dto.UserRequestDto;
import com.projects.userservice.dto.UserResponseDto;
import com.projects.userservice.entity.User;
import com.projects.userservice.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/userservice")
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	
	/*
	 * //Exception Handling for UserId
	 * 
	 * @ExceptionHandler(NoSuchElementException.class) public ResponseEntity<String>
	 * handleNoSuchElementException(NoSuchElementException e) { return
	 * ResponseEntity.status(404).body("User not found: " + e.getMessage()); }
	 */
	
	
	//CRUD Operations for UserId
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserResponseDto> getUserById(@PathVariable long userId) {
		UserResponseDto user = userService.getUserByID(userId);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserResponseDto> addUser(@RequestBody @Valid UserRequestDto user) {
		UserResponseDto savedUser = userService.addUser(user);
		return ResponseEntity.ok(savedUser);
	}
	
	@PutMapping("/users")
	public ResponseEntity <User> updateUser(@RequestBody @Valid User user) {
		userService.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		String act = userService.deleteUser(userId);
		return ResponseEntity.ok(act);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	
	
	
	
	//CRUD Operations for Address
	
	
	
}
