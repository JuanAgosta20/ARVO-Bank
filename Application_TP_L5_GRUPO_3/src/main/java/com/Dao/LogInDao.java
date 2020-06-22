package com.Dao;

import com.Model.User;

public interface LogInDao {

	public User loginUser(String userName, String pass);
}
