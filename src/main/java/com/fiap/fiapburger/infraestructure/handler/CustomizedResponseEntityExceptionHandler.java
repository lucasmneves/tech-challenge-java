
package com.fiap.fiapburger.infraestructure.handler;

import java.util.Date;

import com.fiap.fiapburger.core.domain.exception.ClienteNaoEncontradoException;
import com.fiap.fiapburger.core.domain.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
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

