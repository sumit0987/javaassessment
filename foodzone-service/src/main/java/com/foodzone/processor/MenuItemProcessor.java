package com.foodzone.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.foodzone.dto.MenuItemDto;

@Component
public class MenuItemProcessor implements ItemProcessor<MenuItemDto, MenuItemDto>{

	@Override
	public MenuItemDto process(MenuItemDto item) throws Exception {
		// TODO Auto-generated method stub
		long itemId = item.getItemId();
	    String itemName = item.getItemName();
	    String itemDesc = item.getItemDesc();
	    double itemCost = item.getItemCost();
	    long outletId = item.getOutletId();

	    MenuItemDto menuItemDto = new MenuItemDto(itemId, itemName, itemDesc, itemCost, outletId);
	    
	    return menuItemDto;

	}

}
