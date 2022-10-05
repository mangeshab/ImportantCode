package com.project.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalLevelExceptionHandling {
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiError> productNotFound(ProductNotFoundException e,HttpServletRequest request)
	{
		ApiError error=new ApiError(HttpStatus.NOT_FOUND.value(),new Date(), HttpStatus.NOT_FOUND,e.getMessage(),request.getRequestURI());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException(ArithmeticException e)
	{
		return e.getMessage();
	}
	@ExceptionHandler(IdNotFoundException.class)
	public String DataNotFound(IdNotFoundException e) {
		return e.getMessage();
	}
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ApiError> DataNotFoundException(DataNotFoundException e,HttpServletRequest request)
	{
		ApiError error=new ApiError(HttpStatus.NOT_FOUND.value(),new Date(), HttpStatus.NOT_FOUND,e.getMessage(),request.getRequestURI());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}
}
