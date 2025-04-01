package com.tcs.user_profile.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user_profile.dto.UserOrderDto;
import com.tcs.user_profile.model.Order;
import com.tcs.user_profile.service.OrderService;

@RestController
@RequestMapping("/users/{userId}/orders")
public class OrderController {
	
	OrderService orderService;
	
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}


	@GetMapping
	public ResponseEntity<List<UserOrderDto>> getOrdersByUser(@PathVariable Long userId) {
		return orderService.getOrdersByUser(userId);
	}
	
	@PostMapping
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) {
		return orderService.createOrder(userId, order);
		
	}

}
