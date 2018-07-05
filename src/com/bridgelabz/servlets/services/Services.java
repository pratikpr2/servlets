package com.bridgelabz.servlets.services;

import com.bridgelabz.servlets.model.User;

public interface Services {

	public User getUser(String email,String password);
	public boolean validateUser(String name);
	public void regUser(User user);
}
