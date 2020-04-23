package com.foodzone.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodzone.entity.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
	
	public List<MenuItem> findByItemNameContainingIgnoreCase(String menuItem);
}
