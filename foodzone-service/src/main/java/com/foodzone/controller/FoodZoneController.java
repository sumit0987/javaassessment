package com.foodzone.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodzone.client.BankClient;
import com.foodzone.dto.OrderDto;
import com.foodzone.dto.UserDto;
import com.foodzone.entity.FoodOutlet;
import com.foodzone.entity.MenuItem;
import com.foodzone.entity.Order;
import com.foodzone.entity.User;
import com.foodzone.service.OrderService;
import com.foodzone.service.OutletService;
import com.foodzone.service.UserService;
@RestController
@RequestMapping("/foodzone")
public class FoodZoneController {

	@Autowired
	UserService userService;
	
	@Autowired
	OutletService outletService;
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/users")
	public User saveUser(@RequestBody UserDto userDto){
		User user = userService.saveUser(userDto);
		if(Objects.isNull(user)) {
			throw new RuntimeException("User registration error");
		}
		return user;
	}
	
	@GetMapping("/outlets/{outletName}")
	public List<FoodOutlet> getFoodOutlet(@PathVariable String outletName){
		List<FoodOutlet> outletList = outletService.searchFoodOutlets(outletName);
		if(Objects.isNull(outletList)||outletList.size()==0) {
			throw new RuntimeException("Record not found for : "+outletName);
		}
		return outletList;
	}
	
	@GetMapping("/menuitems/{menuItem}")
	public List<MenuItem> searchMenuItems(@PathVariable String menuItem){
		List<MenuItem> menuItemList = outletService.searchMenuItems(menuItem);
		if(Objects.isNull(menuItemList)||menuItemList.size()==0) {
			throw new RuntimeException("Record not found for : "+menuItem);
		}
		return menuItemList;
	}
	
	@PostMapping("/orders")
	public Order placeOrders(@RequestBody OrderDto orderDto) {
		if(Objects.isNull(orderDto)) {
			throw new RuntimeException("Order cannot be placed......Error occurred");
		}
		Order placedOrder = orderService.placeOrder(orderDto);
		return placedOrder;
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getOrder(@PathVariable long orderId) {
		return orderService.getOrder(orderId);
	}
	
	@GetMapping("/orders/history/{userId}")
	public List<Order> getPastOrders(@PathVariable long userId) {
		return orderService.getPastOrders(userId);
	}
}
