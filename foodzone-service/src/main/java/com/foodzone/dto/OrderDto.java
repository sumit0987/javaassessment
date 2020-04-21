package com.foodzone.dto;

import java.util.List;

public class OrderDto {
	
	List<OrderItemDto> orderItemList;
//	private long cardNumber;
//	private long cvvNumber;
//	private double totalAmount;
	private FundsTransferDto fundsTransferDto;
	private long userId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public FundsTransferDto getFundsTransferDto() {
		return fundsTransferDto;
	}
	public void setFundsTransferDto(FundsTransferDto fundsTransferDto) {
		this.fundsTransferDto = fundsTransferDto;
	}
	public List<OrderItemDto> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDto> orderItemList) {
		this.orderItemList = orderItemList;
	}
//	public long getCardNumber() {
//		return cardNumber;
//	}
//	public void setCardNumber(long cardNumber) {
//		this.cardNumber = cardNumber;
//	}
//	public long getCvvNumber() {
//		return cvvNumber;
//	}
//	public void setCvvNumber(long cvvNumber) {
//		this.cvvNumber = cvvNumber;
//	}
//	public double getTotalAmount() {
//		return totalAmount;
//	}
//	public void setTotalAmount(double totalAmount) {
//		this.totalAmount = totalAmount;
//	}
	
	
}
