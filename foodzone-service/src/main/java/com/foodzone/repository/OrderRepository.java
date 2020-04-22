package com.foodzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.foodzone.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	@Query(value="select * from ORDER_DETAIL where user_id=?1 ORDER BY order_date DESC LIMIT 5",nativeQuery=true)
	public List<Order> findOrderHistory(Long userId);
	
	//public List<Order> findTop5ByUserIdOrderByOrderDateDesc(Long userId);
}
