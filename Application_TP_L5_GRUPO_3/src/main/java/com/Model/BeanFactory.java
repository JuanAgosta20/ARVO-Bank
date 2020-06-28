package com.Model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.AccountDaoImpl;
import com.Dao.AdministrativeDao;
import com.Dao.ClientDaoImpl;
import com.Dao.GenreDaoImpl;
import com.Dao.LocationDaoImpl;
import com.Dao.LogInDaoImpl;
import com.Services.ClientServiceImpl;
import com.Services.AccountServiceImpl;
import com.Services.GenreServiceImpl;
import com.Services.LocationServiceImpl;
import com.Services.UserServiceImpl;

public class BeanFactory{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("com/Resources/Beans.xml");
	
	//MODEL esto no va
	public User createUser() {
		return (User) appContext.getBean("user");
	}
	
	public Account createAccount() {
		return (Account) appContext.getBean("account");
	}
	
	public Administrative createAdministrative() {
		return (Administrative) appContext.getBean("client");
	}
	
	
	
	//DAO

	public LogInDaoImpl createLogInDaoImpl() {
		return (LogInDaoImpl) appContext.getBean("LogInDaoImpl");
	}
	
	public AdministrativeDao createAdminDaoImpl() {
		return (AdministrativeDao) appContext.getBean("AdministrativeDaoImpl");
	}

	public ClientDaoImpl createClientDaoImpl() {
		return (ClientDaoImpl) appContext.getBean("ClientDaoImpl");
	}
	
	public AccountDaoImpl getAccountDaoImpl() {
		return (AccountDaoImpl) appContext.getBean("AccountDaoImpl");
	}
	
	public LocationDaoImpl createLocationDaoImpl() {
		return (LocationDaoImpl) appContext.getBean("LocationDaoImpl");
	}
	
	public GenreDaoImpl createGenreDaoImpl() {
		return (GenreDaoImpl) appContext.getBean("GenreDaoImpl");
	}
	
	
	//SERVICES
	
	public UserServiceImpl createUserServiceImpl() {
		return (UserServiceImpl) appContext.getBean("UserServiceImpl");
	}
	

	public ClientServiceImpl createClientServiceImpl() {
		return (ClientServiceImpl) appContext.getBean("ClientServiceImpl");
	}
	/*
	public AccountServiceImpl getAccountServiceImpl() {
		return (AccountServiceImpl) appContext.getBean("AccountServiceImpl");
	}
	public LocationServiceImpl createLocationServiceImpl() {
		return (LocationServiceImpl) appContext.getBean("LocationServiceImpl");
	}
	
	public GenreServiceImpl createGenreServiceImpl() {
		return (GenreServiceImpl) appContext.getBean("GenreServiceImpl");
	}*/


	
}
