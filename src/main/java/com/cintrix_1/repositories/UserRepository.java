package com.cintrix_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cintrix_1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);

}
