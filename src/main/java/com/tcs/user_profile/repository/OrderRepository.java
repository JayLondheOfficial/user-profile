package com.tcs.user_profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.user_profile.dto.UserOrderDto;
import com.tcs.user_profile.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("SELECT new com.tcs.user_profile.dto.UserOrderDto(u.name, o.productName, o.price, o.createdAt)"+
	" FROM User u JOIN u.orders o WHERE u.id = :userId")
	List<UserOrderDto> findOrderByUserId(Long userId);

}
