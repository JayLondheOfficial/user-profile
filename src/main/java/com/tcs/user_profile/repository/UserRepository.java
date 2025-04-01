package com.tcs.user_profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.user_profile.dto.UserProfileDto;
import com.tcs.user_profile.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select new com.tcs.user_profile.dto.UserProfileDto(u.id, u.name, p.phone, p.address, p.dateOfBirth) "+
	"from User u join u.profile p where u.id = :userId")
	public UserProfileDto getUserById(Long userId);

}

