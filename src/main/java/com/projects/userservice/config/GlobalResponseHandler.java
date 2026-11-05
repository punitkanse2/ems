package com.projects.userservice.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.projects.userservice.dto.ApiResponse;


@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends org.springframework.http.converter.HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, org.springframework.http.MediaType selectedContentType, Class<? extends org.springframework.http.converter.HttpMessageConverter<?>> selectedConverterType, org.springframework.http.server.ServerHttpRequest request, org.springframework.http.server.ServerHttpResponse response) {
		// You can customize the response here if needed
		if(body instanceof ApiResponse) {
			return body; // If it's already an ApiResponse, return it as is
		}
		else {
			return new ApiResponse<>(body);
		}
	}

}
