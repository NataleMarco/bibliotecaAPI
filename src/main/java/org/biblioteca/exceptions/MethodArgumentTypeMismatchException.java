package org.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MethodArgumentTypeMismatchException extends RuntimeException{

		public MethodArgumentTypeMismatchException(String message){
				super(message);
		}

		@Override
		public String getMessage(){
				return super.getMessage();
		}


}
