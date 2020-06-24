package com.Services;


import org.hibernate.Session;

import com.Dao.ClientDaoImpl;
import com.Dao.LogInDaoImpl;
import com.Dao.SessionHandler;
import com.Model.Administrative;
import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.User;

public class UserServiceImpl implements UserService {

	BeanFactory bf = new BeanFactory();
	SessionHandler sHand = new SessionHandler();
	Session session;

	public User getUser(String userName, String pass) {
		User user = bf.createUser();
		LogInDaoImpl login = bf.createLogInDaoImpl();
		user = login.loginUser(userName, pass);
		return user;
	}

	public Client getClient(User user) {
		session =  sHand.getSession();
		Client client;
		try {
			client = (Client) session.get(Client.class, user.getIdUser().intValue());
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
		return client;
	}

	public Administrative getAdmin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
