package com.foodzone.writer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foodzone.dto.MenuItemDto;
import com.foodzone.entity.FoodOutlet;
import com.foodzone.entity.MenuItem;
import com.foodzone.repository.FoodOutletRepository;

@Component
public class DatabaseWriter implements ItemWriter<MenuItemDto>{

	
	@Autowired
	FoodOutletRepository foodOutletRepository;
	
	@Override
	public void write(List<? extends MenuItemDto> items) throws Exception {
		// TODO Auto-generated method stub
		List<MenuItem> menuItems = new ArrayList<>();
		long outletId = items.get(0).getOutletId();
		FoodOutlet outlet = foodOutletRepository.findById(outletId).get();
		for (MenuItemDto menuItemDto : items) {
			MenuItem menu = new MenuItem();
			menu.setItemName(menuItemDto.getItemName());
			menu.setItemDesc(menuItemDto.getItemDesc());
			menu.setItemCost(menuItemDto.getItemCost());
			menu.setFoodOutlet(outlet);
			menuItems.add(menu);
		}
		
		outlet.setMenuItems(menuItems);
		foodOutletRepository.save(outlet);
		
	}
	
}
