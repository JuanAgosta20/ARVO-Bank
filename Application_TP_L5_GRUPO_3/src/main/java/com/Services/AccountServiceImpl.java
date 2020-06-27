package com.Services;

import java.util.ArrayList;

import com.Dao.AccountDao;
import com.Dao.SessionHandler;
import com.Model.Account;
import com.Model.BeanFactory;
import com.Model.typeAccount;

public class AccountServiceImpl implements AccountService{

	BeanFactory bf = new BeanFactory();
	SessionHandler sHand = new SessionHandler();
	
	public Boolean insertAccount(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteAccount(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<typeAccount> getAllTypes() {
		AccountDao ad = bf.getAccountDaoImpl();
		return ad.getAllTypes();
	}

}
