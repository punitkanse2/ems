package com.projects.userservice.dto;

import lombok.*;

@Data
public record UserResponseDto(long userId, String name, String address) {
}
