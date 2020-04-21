package com.foodzone.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodzone.client.BankClient;
import com.foodzone.dto.FundsTransferDto;
import com.foodzone.dto.OrderDto;
import com.foodzone.dto.OrderItemDto;
import com.foodzone.entity.FoodOutlet;
import com.foodzone.entity.Order;
import com.foodzone.entity.OrderItem;
import com.foodzone.entity.User;
import com.foodzone.repository.OrderRepository;
import com.foodzone.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankClient bankClient;
	
	
	@Override
	public Order placeOrder(OrderDto orderDto) {
		// TODO Auto-generated method stub
		//OrderItemDto orderItemDto = new OrderItemDto();
		System.out.println("Inside ");
		List<OrderItemDto> orderItemDtoList = orderDto.getOrderItemList();
		Order order = new Order();
		List<OrderItem> orderItemsList = new ArrayList<OrderItem>();
		for (OrderItemDto orderItemDto : orderItemDtoList) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemName(orderItemDto.getItemName());
			orderItem.setItemCost(orderItemDto.getItemCost());
			orderItem.setQuantity(orderItemDto.getQuantity());
			orderItem.setTotalCost(orderItemDto.getItemCost()*orderItemDto.getQuantity());
			orderItemsList.add(orderItem);
		}
		double totalOrderCost=0.00;
		for (OrderItem orderItem : orderItemsList) {
			totalOrderCost = totalOrderCost+orderItem.getTotalCost();
		}
		long userId = orderDto.getUserId();
		Optional<User> user = userRepository.findById(userId);
		order.setOrderCost(totalOrderCost);
		order.setPaymentId(567);
		order.setOrderItems(orderItemsList);
		order.setOrderDate(new Date());
		order.setUser(user.get());

		String status = bankClient.transferFunds(orderDto.getFundsTransferDto());
		if(Objects.isNull(status)||!status.equalsIgnoreCase("Funds transferred")) {
			throw new RuntimeException("Order cannot be placed......Error occurred");
		}
		
		Order orderPlaced = orderRepository.save(order);
		return orderPlaced;
		
	}


	@Override
	public Order getOrder(long orderId) {
		// TODO Auto-generated method stub
		Optional<Order> order = orderRepository.findById(orderId);
		if(Objects.isNull(order)) {
			throw new RuntimeException("No Record Found");
		}
		return order.get();
	}


	@Override
	public List<Order> getPastOrders(long userId) {
		// TODO Auto-generated method stub
		List<Order> orderList = orderRepository.findTop5ByUserIdOrderByorderDateDesc(userId);
		if(Objects.isNull(orderList)||orderList.size()==0) {
			throw new RuntimeException("No Record Found");
		}
		return orderList;
	}

	

}
