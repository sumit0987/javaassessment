package com.foodzone.service;

import java.util.List;

import com.foodzone.entity.FoodOutlet;
import com.foodzone.entity.MenuItem;

public interface OutletService {
	public List<FoodOutlet> searchFoodOutlets(String outletName);
	public List<MenuItem> searchMenuItems(String menuItem);
}
