package com.basic.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeException {
	
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;

}
