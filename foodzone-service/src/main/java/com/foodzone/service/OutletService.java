package com.foodzone.service;

import java.util.List;

import com.foodzone.entity.FoodOutlet;

public interface OutletService {
	public List<FoodOutlet> searchFoodOutlets(String outletName);
}
