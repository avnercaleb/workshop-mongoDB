package com.workshopmongo.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardException> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){		
		String error = "Usuario nao encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardException err = new StandardException(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
