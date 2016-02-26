package com.amazonpremium.dao;

import com.amazonpremium.model.User;

public interface UserDAO {
	
	public boolean login(String username, String password);
	public void registration(User newUser);
	
}
