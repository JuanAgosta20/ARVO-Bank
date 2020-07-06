package com.Services;

import com.Model.Administrative;
import com.Model.Client;
import com.Model.User;

public interface UserService {

	public User getUser(String userName, String pass);
	public User getUser(int id); //Id de cliente o admin, no de usuario
	public Client getClient(User user);
	public Administrative getAdmin(User user);
	public Boolean existUserName(String username);
	public Boolean updatePassword(String pass, int id);
	
}
