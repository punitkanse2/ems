package com.projects.userservice.dto;

import lombok.*;

@Data
public record UserRequestDto(String name, String address) {
}
