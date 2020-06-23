package com.Services;


import com.Dao.ClientDaoImpl;
import com.Dao.LogInDaoImpl;
import com.Model.Administrative;
import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.User;

public class UserServiceImpl implements UserService {

	BeanFactory bf = new BeanFactory();

	public User getUser(String userName, String pass) {
		User user = bf.createUser();
		LogInDaoImpl login = bf.createLogInDaoImpl();
		user = login.loginUser(userName, pass);
		return user;
	}

	public Client getClient(User user) {
		ClientDaoImpl cdao = bf.createClientDaoImpl();
		Client client = cdao.getClient(user.getIdUser());
		return client;
	}

	public Administrative getAdmin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
