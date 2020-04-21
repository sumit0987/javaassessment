package com.foodzone.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodzone.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	public List<Order> findTop5ByUserIdOrderByorderDateDesc(long userId);
}
