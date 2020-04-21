package com.foodzone.repository;

import org.springframework.data.repository.CrudRepository;

import com.foodzone.entity.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

}
