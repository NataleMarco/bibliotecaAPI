package org.biblioteca.exceptions;

public class MethodArgumentTypeMismatchException extends RuntimeException{

		public MethodArgumentTypeMismatchException(String message){
				super(message);
		}

		@Override
		public String getMessage(){
				return super.getMessage();
		}


}
