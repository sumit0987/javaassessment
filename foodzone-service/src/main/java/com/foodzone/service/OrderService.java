package com.foodzone.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.foodzone.dto.OrderDto;
import com.foodzone.entity.Order;

public interface OrderService {
	public Order placeOrder(OrderDto orderDto);
	public Order getOrder(long orderId);
	public List<Order> getPastOrders(long userId);
}
