package com.projects.userservice.mapper;

import org.springframework.stereotype.Component;

import com.projects.userservice.dto.UserRequestDto;
import com.projects.userservice.dto.UserResponseDto;
import com.projects.userservice.entity.User;

@Component
public class UserMapper {
	
	public User userRequestDtotoUser(UserRequestDto dto) {
		// TODO UserRequestDto to User Entity Conversion
		User user = new User();
		
		user.setName(dto.name());
		user.setEmail(dto.email());
		user.setAddress(dto.address());
		return user;
	}
	public UserResponseDto userToUserResponseDto(User user) {
		// TODO UserRequestDto to User Entity Conversion
		return new UserResponseDto(user.getUserId(), user.getName(), user.getEmail(), user.getAddress(), user.isActive(), user.getCreatedAt());
	}
	
	
}
