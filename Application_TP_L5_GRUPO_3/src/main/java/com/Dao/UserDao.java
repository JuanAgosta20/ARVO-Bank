package com.Dao;

import com.Model.User;

public interface UserDao {
	
	public User getUser(int id);
	public Boolean existUserName(String username);
	public Boolean updatePass(String pass, Integer id);

}
