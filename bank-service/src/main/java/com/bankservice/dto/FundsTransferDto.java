package com.bankservice.dto;

import org.springframework.stereotype.Component;

@Component
public class FundsTransferDto {
	//private int customerId;
	private double transferAmount;
	//private int payeeId;
	private long cardNumber;
	private long cvvNumber; 
	
	
//	public int getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
	
//	public int getPayeeId() {
//		return payeeId;
//	}
//	public void setPayeeId(int payeeId) {
//		this.payeeId = payeeId;
//	}
	
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public long getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(long cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	
	
	
}
