package com.bankservice.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class BankServiceExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> recordNotFoundException(RecordNotFoundException ex, WebRequest request) 
    {
       
        ErrorResponse error = new ErrorResponse("No Records Found", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	

    protected ResponseEntity<ErrorResponse> invalidArguments(ParameterInvalidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse error = new ErrorResponse("parameters not valid", ex.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
