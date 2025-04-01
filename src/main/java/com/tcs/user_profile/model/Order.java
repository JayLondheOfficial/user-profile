package com.tcs.user_profile.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	private BigDecimal price;
	private LocalDate createdAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDate.now();
	}
	
	


}
