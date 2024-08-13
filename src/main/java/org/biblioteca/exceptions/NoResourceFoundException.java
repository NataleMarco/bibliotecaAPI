package org.biblioteca.exceptions;

public class NoResourceFoundException extends RuntimeException{

		public NoResourceFoundException(String message){
				super(message);
		}

		@Override
		public String getMessage(){
				return super.getMessage();
		}
}
