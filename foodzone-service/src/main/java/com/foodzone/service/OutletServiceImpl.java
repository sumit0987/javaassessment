package com.foodzone.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodzone.entity.FoodOutlet;
import com.foodzone.entity.MenuItem;
import com.foodzone.repository.FoodOutletRepository;
import com.foodzone.repository.MenuItemRepository;

@Service
public class OutletServiceImpl implements OutletService {

	@Autowired
	FoodOutletRepository foodOutletRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Override
	public List<FoodOutlet> searchFoodOutlets(String outletName) {
		// TODO Auto-generated method stub
		List<FoodOutlet> outletList = foodOutletRepository.findByOutletNameContaining(outletName);
		if(Objects.isNull(outletList)||outletList.size()==0) {
			throw new RuntimeException("Record Not Found");
		}
		return outletList;
	}

	@Override
	public List<MenuItem> searchMenuItems(String menuItem) {
		// TODO Auto-generated method stub
		List<MenuItem> itemList = menuItemRepository.findByItemNameContainingIgnoreCase(menuItem);
		if(Objects.isNull(itemList)||itemList.size()==0) {
			throw new RuntimeException("Record Not Found");
		}
		return itemList;
	}

}
