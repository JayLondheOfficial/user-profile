package com.tcs.user_profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	
	
}
