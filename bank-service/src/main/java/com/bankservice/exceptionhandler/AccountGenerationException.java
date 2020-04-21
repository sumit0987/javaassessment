package com.bankservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountGenerationException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1975344731832696985L;

	public AccountGenerationException(String msg) {
		super(msg);
	}
}
