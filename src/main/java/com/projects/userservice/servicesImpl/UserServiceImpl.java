package com.projects.userservice.servicesImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.userservice.dto.UserRequestDto;
import com.projects.userservice.dto.UserResponseDto;
import com.projects.userservice.entity.User;
import com.projects.userservice.mapper.UserMapper;
import com.projects.userservice.repository.UserRepository;
import com.projects.userservice.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository repository;
	
	private final UserMapper userMapper = new UserMapper();
	
	//CRUD Operation Services for UserId
	public UserResponseDto getUserByID(long userId){
		if (!repository.existsById(userId)) {
			throw new NoSuchElementException("User not found with id: " + userId);
		}
		else {
			User user = repository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
			return userMapper.userToUserResponseDto(user);
		}
	}
	
	@Override
	public UserResponseDto addUser(UserRequestDto user){
		User userEntity = userMapper.userRequestDtotoUser(user);
		return userMapper.userToUserResponseDto(repository.save(userEntity));
	}

	@Override
	public Optional<User> updateUser(User user) {
		Optional<User> existingUser = repository.findById(user.getUserId());
		if (existingUser.isPresent()) {
			User updatedUser = existingUser.get();
			updatedUser.setAddress(user.getAddress());
			updatedUser.setName(user.getName());
			return Optional.of(repository.save(updatedUser));
		} else {
			throw new NoSuchElementException("User not found with given id");
		}
	}
	
	@Override
	public String deleteUser(Long id) {
		if (!repository.existsById(id)) {
			throw new NoSuchElementException("User not found with id: " + id);
		}
		else {
			repository.deleteById(id);
			return "User deleted successfully";
		}
	}
	
	
	
	
	
	//CRUD Operation Services for Address
	
	
	
	
	//Get All Users	
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
}
