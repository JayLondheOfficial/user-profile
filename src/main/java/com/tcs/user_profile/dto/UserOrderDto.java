package com.tcs.user_profile.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserOrderDto(
		String UserName,
		String productName,
		BigDecimal price,
		LocalDate orderDate
		
		
		
		) {

}
