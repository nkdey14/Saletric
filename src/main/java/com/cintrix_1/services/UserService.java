package com.cintrix_1.services;

import com.cintrix_1.entities.User;

public interface UserService {

	public void saveUser(User u);

	public User findByUserEmail(String email);

}
