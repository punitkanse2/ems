package com.projects.userservice.config;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return ResponseEntity.status(404).body("User not found: " + e.getMessage());
	}
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(
            Exception ex) {

        return new ResponseEntity<>(
                "Something went wrong",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
