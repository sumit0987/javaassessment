package com.foodzone.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodzone.entity.FoodOutlet;

@Repository
public interface FoodOutletRepository extends CrudRepository<FoodOutlet, Long> {
	
	public List<FoodOutlet> findByOutletNameContaining(String outletName);
	
}
