package com.Dao;

import org.hibernate.Session;

import com.Model.User;

public class UserDaoImpl implements UserDao{
	

	SessionHandler sHand = new SessionHandler();
	Session session;

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
