package com.projects.userservice.dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
public record UserResponseDto(
		long userId,
		String name,
		String email,
		String address,
		boolean isActive,
		LocalDateTime createdAt) {
}
