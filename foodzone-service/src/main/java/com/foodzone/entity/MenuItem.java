package com.foodzone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="menu_item")
public class MenuItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long itemId;
	private String itemName;
	private String itemDesc;
	private double itemCost;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
						CascadeType.PERSIST,CascadeType.REFRESH,
						CascadeType.REMOVE})
	@JoinColumn(name="outlet_id")
	@JsonIgnore
	private FoodOutlet foodOutlet;

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

	public FoodOutlet getFoodOutlet() {
		return foodOutlet;
	}

	public void setFoodOutlet(FoodOutlet foodOutlet) {
		this.foodOutlet = foodOutlet;
	}
	
	
}
