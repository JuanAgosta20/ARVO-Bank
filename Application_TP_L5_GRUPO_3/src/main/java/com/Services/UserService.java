package com.Services;

import com.Model.Administrative;
import com.Model.Client;
import com.Model.User;

public interface UserService {

	public User getUser(String userName, String pass);
	public Client getClient(User user);
	public Administrative getAdmin(User user);
	
}
