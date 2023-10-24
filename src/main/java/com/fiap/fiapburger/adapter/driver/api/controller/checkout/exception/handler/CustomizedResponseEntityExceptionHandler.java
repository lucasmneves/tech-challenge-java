package com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.adapter.driver.api.controller.checkout.exception.ExceptionResponse;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest req){
		
		ExceptionResponse exception = new ExceptionResponse(
																new Date(),
																ex.getMessage(),
																req.getDescription(false)
															);
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public final ResponseEntity<ExceptionResponse> handlerNotFoundException(Exception ex, WebRequest req){
		
		ExceptionResponse exception = new ExceptionResponse(
																new Date(),
																ex.getMessage(),
																req.getDescription(false)
															);
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
}
