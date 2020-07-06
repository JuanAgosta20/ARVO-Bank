package com.Dao;


import org.hibernate.Query;
import org.hibernate.Session;
import com.Model.User;

public class LogInDaoImpl implements LogInDao {

	SessionHandler sHand ;
	Session session;

	public User loginUser(String userName, String pass) {
		User user;
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "From User u WHERE u.userName =:userName AND u.password =:pass AND u.state = 1";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("userName", userName);
		query.setParameter("pass", pass);
		try {
			user = (User) query.uniqueResult();
		}catch (Exception e) {
			return null;
		}
		return user;
	}

}
