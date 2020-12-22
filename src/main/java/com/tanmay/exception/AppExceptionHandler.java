package com.tanmay.exception;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tanmay.response.ErrorResponse;

@RestControllerAdvice
public class AppExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
		List<String> msg = exc.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(toList());
		
		return new ErrorResponse(400, msg);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = CarAlreadyExistException.class)
	public ErrorResponse onCarAlreadyExist(CarAlreadyExistException exc) {
		List<String> msg = Arrays.asList(exc.getMessage());
		
		return new ErrorResponse(400, msg);
	}
	
	@ResponseStatus
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorResponse onConstraintException(ConstraintViolationException exc) {
		List<String> msg = exc.getConstraintViolations().stream().map(e -> e.getMessage()).collect(Collectors.toList());
		
		return new ErrorResponse(400, msg);
	}
}
