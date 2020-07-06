package com.Dao;



import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.User;

public class UserDaoImpl implements UserDao{
	

	SessionHandler sHand;
	Session session;

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean existUserName(String username) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "From User u where u.userName = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
	
		return query.uniqueResult() != null;
	}

	public Boolean updatePass(String pass, Integer id) {
		sHand = new SessionHandler();
		session = sHand.getSession();
		String hql = "update User u set u.password=:pass  where u.idUser= :id";
		Query query = (Query)session.createQuery(hql);
		query.setParameter("pass", pass);
		query.setParameter("id", id);
		try{
			Boolean res = query.executeUpdate() == 1 ? true : false;
			if (res)
				sHand.commit();
			else
				sHand.rollback();
			return res;
		}catch (Exception e) {
			return false;
		}
	}

}
