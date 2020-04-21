package com.foodzone.dto;

public class MenuItemDto {
	private long itemId;
	private String itemName;
	private String itemDesc;
	private double itemCost;
	private long outletId;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	public long getOutletId() {
		return outletId;
	}
	public void setOutletId(long outletId) {
		this.outletId = outletId;
	}
	public MenuItemDto(long itemId, String itemName, String itemDesc, double itemCost, long outletId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemCost = itemCost;
		this.outletId = outletId;
	}
	
	public MenuItemDto() {
		
	}
}
