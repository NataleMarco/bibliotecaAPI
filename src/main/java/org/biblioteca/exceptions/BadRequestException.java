package	org.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BadRequestException extends RuntimeException{

	public BadRequestException(String message){
		super(message);
	}

	@Override
	public String getMessage(){
		return super.getMessage();
	}

}

