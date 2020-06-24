package com.Model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.AdministrativeDao;
import com.Dao.ClientDaoImpl;
import com.Dao.LogInDaoImpl;
import com.Services.UserServiceImpl;

public class BeanFactory{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("com/Resources/Beans.xml");
	

	//MODEL
	public User createUser() {
		return (User) appContext.getBean("user");
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
	
	//SERVICES
	public UserServiceImpl createUserServiceImpl() {
		return (UserServiceImpl) appContext.getBean("UserServiceImpl");
	}

	
}
