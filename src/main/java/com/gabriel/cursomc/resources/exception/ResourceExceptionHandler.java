package com.gabriel.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabriel.cursomc.services.exceptions.ObjectNotFoundExcepiton;

@ControllerAdvice
public class ResourceExceptionHandler {
	//Implementando uma classe que vai interceptar as excecoes e ela tem q ter essa assinatura
	
	@ExceptionHandler(ObjectNotFoundExcepiton.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExcepiton e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
