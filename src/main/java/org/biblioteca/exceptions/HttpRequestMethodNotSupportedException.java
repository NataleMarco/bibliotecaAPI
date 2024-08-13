package org.biblioteca.exceptions;
public class HttpRequestMethodNotSupportedException extends RuntimeException{

		public HttpRequestMethodNotSupportedException(String message){
				super(message);
		}

		@Override
		public String getMessage(){
				return super.getMessage();
		}


}
