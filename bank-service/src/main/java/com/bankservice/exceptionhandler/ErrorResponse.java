package com.bankservice.exceptionhandler;

import java.util.List;

public class ErrorResponse {
	
	private String message;
    private String detail;
    
	public ErrorResponse(String message, String detail) {
        super();
        this.message = message;
        this.detail=detail;
    }
  
    public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	

	
}
