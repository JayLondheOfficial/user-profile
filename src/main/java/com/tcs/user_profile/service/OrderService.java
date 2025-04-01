package com.tcs.user_profile.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcs.user_profile.dto.UserOrderDto;
import com.tcs.user_profile.model.Order;
import com.tcs.user_profile.model.User;
import com.tcs.user_profile.repository.OrderRepository;
import com.tcs.user_profile.repository.UserRepository;

@Service
public class OrderService {
	
	private OrderRepository orderRepository;
	private UserRepository userRepository;

	
	
	public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
		super();
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
	}


	public ResponseEntity<List<UserOrderDto>>  getOrdersByUser(Long userId) {
		List<UserOrderDto> orders = orderRepository.findOrderByUserId(userId);
		
		return ResponseEntity.ok(orders);
		
	}
	
	
	public Order createOrder(Long UserId, Order order) {
		User user = userRepository.findById(UserId).orElseThrow(()->new RuntimeException("User Not Found"));
		order.setUser(user);
		return orderRepository.save(order);
	}

}
