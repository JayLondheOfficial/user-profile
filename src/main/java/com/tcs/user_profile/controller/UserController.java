package com.tcs.user_profile.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user_profile.model.User;
import com.tcs.user_profile.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@GetMapping
	public List<User> getAllUser() {
		return userService.getAllUsers();
		
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUserById(id);
		
	}
	
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);
		
	}

}
