package com.tcs.user_profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.user_profile.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
