package com.projects.userservice.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RestController
@RequestMapping("/userservice")
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	//CRUD Operations for UserId
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable long userId) {
		try {
			User user = userService.getUserByID(userId);
			return ResponseEntity.ok(user);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> addUser(@RequestBody UserRequestDto user) {
		try{
			UserResponseDto savedUser = userService.addUser(user);
			if(savedUser.userId() != 0){
				// Return a success message with the saved user ID
				return ResponseEntity.ok("User added successfully with ID: " + savedUser.userId());
			}
			else{
				throw new Exception("Something went wrong while adding the user.");
			}
		}
		catch(Exception e){
			return ResponseEntity.status(500).body("Error adding user: " + e.getMessage());
		}
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try{
			userService.updateUser(user);
			return ResponseEntity.ok(user);
		}
		catch(Exception e){
			return ResponseEntity.status(500).build();
		}
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		try{
			String act = userService.deleteUser(userId);
			return ResponseEntity.ok(act);
		}
		catch(Exception e){
			return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try{
			List<User> users = userService.getAllUsers();
			return ResponseEntity.ok(users);
		}
		catch(Exception e){
			return ResponseEntity.status(500).build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	//CRUD Operations for Address
	
	
	
}
