package com.projects.userservice.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class ApiResponse<T> {
	private Instant currentTime;
	private T users;
	
	public ApiResponse() {
		this.currentTime = Instant.now();
	}
	
	public ApiResponse(T users) {
		this();
		this.users = users;
	}
	
	public Instant getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Instant currentTime) {
		this.currentTime = currentTime;
	}

	public T getUsers() {
		return users;
	}

	public void setUsers(T users) {
		this.users = users;
	}
	
	
	
}
