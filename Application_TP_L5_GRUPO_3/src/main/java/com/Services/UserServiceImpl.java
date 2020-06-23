package com.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.ClientDaoImpl;
import com.Dao.LogInDaoImpl;
import com.Model.Administrative;
import com.Model.Client;
import com.Model.User;

public class UserServiceImpl implements UserService {

	ApplicationContext appContext = new ClassPathXmlApplicationContext("com/Resources/Beans.xml");

	public User getUser(String userName, String pass) {
		User user = (User) appContext.getBean("User");
		LogInDaoImpl login = (LogInDaoImpl) appContext.getBean("LogInDaoImpl");
		user = login.loginUser(userName, pass);
		return user;
	}

	public Client getClient(User user) {
		ClientDaoImpl cdao = (ClientDaoImpl) appContext.getBean("ClientDaoImpl");
		Client client = cdao.getClient(user.getIdUser());
		return client;
	}

	public Administrative getAdmin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
