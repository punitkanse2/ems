package com.projects.userservice.services;

import java.util.*;

import com.projects.userservice.dto.UserRequestDto;
import com.projects.userservice.dto.UserResponseDto;
import com.projects.userservice.entity.User;

public interface UserService {
	
	User getUserByID(long id);
	UserResponseDto addUser(UserRequestDto user);
	Optional<User> updateUser(User user);
	String deleteUser(Long id);
	List<User> getAllUsers();
	
}
