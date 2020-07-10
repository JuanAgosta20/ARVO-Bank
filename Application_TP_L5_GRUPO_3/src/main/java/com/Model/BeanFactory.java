package com.Model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.AccountDaoImpl;
import com.Dao.AdministrativeDao;
import com.Dao.ClientDaoImpl;
import com.Dao.GenreDaoImpl;
import com.Dao.LocationDaoImpl;
import com.Dao.LogInDaoImpl;
import com.Dao.Paginator;
import com.Dao.TransactionDaoImpl;
import com.Services.ClientServiceImpl;
import com.Services.AccountServiceImpl;
import com.Services.GenreServiceImpl;
import com.Services.LocationServiceImpl;
import com.Services.TransactionServiceImpl;
import com.Services.UserServiceImpl;

public class BeanFactory{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("com/Resources/Beans.xml");
	
	//MODEL
	public static User createUser() {
		return (User) appContext.getBean("user");
	}
	
	public static Account createAccount() {
		return (Account) appContext.getBean("account");
	}
	
	public static Administrative createAdministrative() {
		return (Administrative) appContext.getBean("administrative");
	}
	
	public static Client createClient() {
		return (Client) appContext.getBean("client");
	}
	
	//DAO

	public static LogInDaoImpl createLogInDaoImpl() {
		return (LogInDaoImpl) appContext.getBean("LogInDaoImpl");
	}
	
	public static AdministrativeDao createAdminDaoImpl() {
		return (AdministrativeDao) appContext.getBean("AdministrativeDaoImpl");
	}

	public static ClientDaoImpl createClientDaoImpl() {
		return (ClientDaoImpl) appContext.getBean("ClientDaoImpl");
	}
	
	public static AccountDaoImpl getAccountDaoImpl() {
		return (AccountDaoImpl) appContext.getBean("AccountDaoImpl");
	}
	
	public static LocationDaoImpl createLocationDaoImpl() {
		return (LocationDaoImpl) appContext.getBean("LocationDaoImpl");
	}
	
	public static GenreDaoImpl createGenreDaoImpl() {
		return (GenreDaoImpl) appContext.getBean("GenreDaoImpl");
	}
	
	public static TransactionDaoImpl createTransactionDaoImpl() {
		return (TransactionDaoImpl) appContext.getBean("TransactionDaoImpl");
	}
	
	//SERVICES
	
	public static UserServiceImpl createUserServiceImpl() {
		return (UserServiceImpl) appContext.getBean("UserServiceImpl");
	}
	

	public static ClientServiceImpl createClientServiceImpl() {
		return (ClientServiceImpl) appContext.getBean("ClientServiceImpl");
	}
	
	public static AccountServiceImpl createAccountServiceImpl() {
		return (AccountServiceImpl) appContext.getBean("AccountServiceImpl");
	}
	public static LocationServiceImpl createLocationServiceImpl() {
		return (LocationServiceImpl) appContext.getBean("LocationServiceImpl");
	}
	
	public static GenreServiceImpl createGenreServiceImpl() {
		return (GenreServiceImpl) appContext.getBean("GenreServiceImpl");
	}

	public static TransactionServiceImpl createTransactionServiceImpl() {
		return (TransactionServiceImpl) appContext.getBean("TransactionServiceImpl");
	}
	
}
