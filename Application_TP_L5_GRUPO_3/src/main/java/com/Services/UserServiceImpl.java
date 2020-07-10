package com.Services;


import com.Dao.AdministrativeDao;
import com.Dao.ClientDaoImpl;
import com.Dao.LogInDao;
import com.Dao.UserDao;
import com.Dao.UserDaoImpl;
import com.Model.Administrative;
import com.Model.BeanFactory;
import com.Model.Client;
import com.Model.User;

public class UserServiceImpl implements UserService {


	public User getUser(String userName, String pass) {
		User user = BeanFactory.createUser();
		LogInDao login = BeanFactory.createLogInDaoImpl();
		user = login.loginUser(userName, pass);
		return user;
	}

	public Client getClient(User user) {
		ClientDaoImpl cliDao = BeanFactory.createClientDaoImpl();
		return cliDao.getClient(user);
	}

	public Administrative getAdmin(User user) {
		AdministrativeDao admDao = BeanFactory.createAdminDaoImpl();
		return admDao.getAdministrative(user);
	}

	public User getUser(int id) {
		return null;
	}

	public Boolean existUserName(String username) {
		UserDao ud = new UserDaoImpl();
		return ud.existUserName(username);
	}

	public Boolean updatePassword(String pass, int id) {
		UserDao ud = new UserDaoImpl();
		return ud.updatePass(pass,id);
	}

}
