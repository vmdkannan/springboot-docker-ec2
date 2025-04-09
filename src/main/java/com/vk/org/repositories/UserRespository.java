package com.vk.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.org.entities.User;

public interface UserRespository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

	
	
}
