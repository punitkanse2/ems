package com.projects.userservice.dto;

import java.time.Instant;

public record UserResponseDto(
		long userId,
		String name,
		String email,
		String address,
		boolean isActive,
		Instant createdAt) {
}
