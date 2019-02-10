package com.eat.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import static org.springframework.http.HttpStatus.*;

/**
 * TODO 에러 처리는 확인 후 진행 필요
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	/*@ResponseStatus(value = NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<String> handleError404() {
		return new ResponseEntity<String>("404 not found", HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(value = BAD_REQUEST)
	@ExceptionHandler({
		HttpMessageNotReadableException.class,
		MethodArgumentNotValidException.class,
		HttpRequestMethodNotSupportedException.class,
		MissingServletRequestParameterException.class
	})
	public String handleError400() {
		return "error/400";
	}

	@ResponseStatus(value = INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleError(Exception e) throws Exception {
		throw e;
	}

	*//**
	 * Text type response
	 *//*
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<String> handleError415() {
		return new ResponseEntity<String>("Sorry, No supported media type.", UNSUPPORTED_MEDIA_TYPE);
	}*/

}
