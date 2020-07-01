package com.Dao;



import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.User;

public class UserDaoImpl implements UserDao{
	

	SessionHandler sHand = new SessionHandler();
	Session session;

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean existUserName(String username) {
		session = sHand.getSession();
		String hql = "From User u where u.userName = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
	
		return query.uniqueResult() != null;
	}

}
