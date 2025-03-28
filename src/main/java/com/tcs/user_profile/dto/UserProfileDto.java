package com.tcs.user_profile.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserProfileDto {
	private Long userId;
	private String userName;
	private String phone;
	private String address;
	private LocalDate dateOfBirth;
	

}
