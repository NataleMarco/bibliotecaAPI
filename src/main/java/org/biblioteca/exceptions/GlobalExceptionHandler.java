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
public class GlobalExceptionHandler { 

		@ExceptionHandler(ResourceNotFoundException.class)
		protected ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex){
				return buildResponseEntity(HttpStatus.NOT_FOUND,ex.getMessage());
		}

		@ExceptionHandler(BadRequestException.class)
		protected ResponseEntity<?> handleBadRequest(BadRequestException ex){
				return buildResponseEntity(HttpStatus.BAD_REQUEST,ex.getMessage());
		}

		@ExceptionHandler(MethodArgumentTypeMismatchException.class)
		protected ResponseEntity<?> handleMethodArgumentTipeMismatch(){
				return buildResponseEntity(HttpStatus.BAD_REQUEST,"El tipo de dato ingresado no es valido");
		}

		@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
		protected ResponseEntity<?> handleRequestMethodNotSupported() {
				return buildResponseEntity(HttpStatus.METHOD_NOT_ALLOWED, "El Método de solicitud no está soportado");
		}

		@ExceptionHandler(NoResourceFoundException.class)
		protected ResponseEntity<?> handleNoResourceFound(){
				return buildResponseEntity(HttpStatus.NOT_FOUND, "No se encontro el URL introducido");
		}

		@ExceptionHandler(HttpMessageNotReadableException.class)
		protected ResponseEntity<?> handleMessageNotReadableException(){
				return buildResponseEntity(HttpStatus.BAD_REQUEST,"Los datos introducidos no son valiods para completar la operacion");
		}

		//Generic Exception, this will give a server error if there is something that is not especified.
		//@ExceptionHandler(Exception.class)
		//protected ResponseEntity<?> handleException(Exception ex){
		//		return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR,"Ha ocurrido un error interno");
		//}

		private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message){
				Map<String, Object> body = new LinkedHashMap<>();
				body.put("timeStamp", LocalDateTime.now());
				body.put("status", status.value());
				body.put("error",status.getReasonPhrase());
				body.put("message",message);
				return new ResponseEntity<>(body,status);
		}

}

