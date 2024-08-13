package org.biblioteca.exceptions;

public class HttpMessageNotReadableException extends RuntimeException{

		public HttpMessageNotReadableException (String message) {
				super(message);
		}

		@Override
		public String getMessage(){
				return super.getMessage();
		}
}

