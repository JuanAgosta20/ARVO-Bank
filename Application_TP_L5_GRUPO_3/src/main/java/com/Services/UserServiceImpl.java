package com.Services;


import com.Dao.AdministrativeDao;
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
	

	public User getUser(String userName, String pass) {
		User user = bf.createUser();
		LogInDaoImpl login = bf.createLogInDaoImpl();
		user = login.loginUser(userName, pass);
		return user;
	}

	public Client getClient(User user) {
		ClientDaoImpl cliDao = bf.createClientDaoImpl();
		return cliDao.getClient(user);
	}

	public Administrative getAdmin(User user) {
		AdministrativeDao admDao = bf.createAdminDaoImpl();
		return admDao.getAdministrative(user);
	}

	public User getUser(int id) {
		return null;
	}

}
