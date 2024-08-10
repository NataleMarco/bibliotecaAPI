package org.biblioteca.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExcepcionHandler { 

		@ExceptionHandler(ResourceNotFoundException.class)
		protected ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex){
				return buildResponseEntity(HttpStatus.NOT_FOUND,ex.getMessage());
		}

		@ExceptionHandler(BadRequestException.class)
		protected ResponseEntity<?> handleBadRequest(BadRequestException ex){
				return buildResponseEntity(HttpStatus.BAD_REQUEST,ex.getMessage());
		}

		@ExceptionHandler(MethodArgumentTypeMismatchException.class)
		protected ResponseEntity<?> handleMethodArgumentTipeMismatch(MethodArgumentTypeMismatchException ex){
				return buildResponseEntity(HttpStatus.BAD_REQUEST,"El tipo de dato ingresado no es valido");
		}

		@ExceptionHandler(Exception.class)
		protected ResponseEntity<?> handleExceptino(Exception ex){
				return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR,"Ha ocurrido un error interno");
		}

		private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message){
				Map<String, Object> body = new LinkedHashMap<>();
				body.put("timeStamp", LocalDateTime.now());
				body.put("status", status.value());
				body.put("error",status.getReasonPhrase());
				body.put("message",message);
				return new ResponseEntity<>(body,status);
		}

}

