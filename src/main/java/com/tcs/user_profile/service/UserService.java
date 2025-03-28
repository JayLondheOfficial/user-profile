package com.tcs.user_profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcs.user_profile.dto.UserProfileDto;
import com.tcs.user_profile.model.User;
import com.tcs.user_profile.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User>getAllUsers() {
		return userRepository.findAll();
		
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
		
	}

	public ResponseEntity<UserProfileDto> getUserById(Long id) {
	User user= userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found with id : "+ id));
	UserProfileDto userProfileDtoResponse = new UserProfileDto(
			user.getId(),
			user.getName(),
			user.getProfile().getPhone(), 
			user.getProfile().getAddress(),
			user.getProfile().getDateOfBirth());
	return ResponseEntity.ok(userProfileDtoResponse);
	
	
	
	
	}

	
	
}
