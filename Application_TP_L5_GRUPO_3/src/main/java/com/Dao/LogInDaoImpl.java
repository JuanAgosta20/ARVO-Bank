package com.Dao;


import org.hibernate.Query;
import org.hibernate.Session;
import com.Model.User;

public class LogInDaoImpl implements LogInDao {

	SessionHandler sHand = new SessionHandler();
	Session session;

	public User loginUser(String userName, String pass) {
		User user;
		session = sHand.getSession();
		String hql = "From User AS U WHERE U.userName = "+ userName 
				+ "AND U.password = " + pass;
		Query query = session.createQuery(hql);
		try {
			user = (User) query.list();
		}catch (Exception e) {
			return null;
		}
		
		sHand.close();
		return user;
	}

}
