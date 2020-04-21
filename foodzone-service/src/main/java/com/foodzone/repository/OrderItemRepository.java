package com.foodzone.repository;

import org.springframework.data.repository.CrudRepository;

import com.foodzone.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
