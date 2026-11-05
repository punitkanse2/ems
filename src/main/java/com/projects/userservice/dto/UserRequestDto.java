package com.projects.userservice.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public record UserRequestDto(
		@NotBlank(message = "Name is mandatory")
		String name,
		
		@NotBlank(message = "Email is mandatory")
		@Email(message = "Email should be valid")
		String email,
		
		String address,
		LocalDateTime createdAt) {
}
