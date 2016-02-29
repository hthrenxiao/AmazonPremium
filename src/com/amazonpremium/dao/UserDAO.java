package com.amazonpremium.dao;

import com.amazonpremium.model.User;

public interface UserDAO {
	
	public boolean login(String username, String password);
	public boolean registration(User newUser);
	
}
