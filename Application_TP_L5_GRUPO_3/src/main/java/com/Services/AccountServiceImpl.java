package com.Services;

import java.util.ArrayList;

import com.Dao.AccountDao;
import com.Dao.AccountDaoImpl;
import com.Dao.SessionHandler;
import com.Model.Account;
import com.Model.BeanFactory;
import com.Model.typeAccount;

public class AccountServiceImpl implements AccountService{

	BeanFactory bf = new BeanFactory();
	AccountDao ad = new AccountDaoImpl();
	
	public Boolean insertAccount(Account acc) {
		return ad.insertAccount(acc);
	}

	public Boolean deleteAccount(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<typeAccount> getAllTypes() {
		return ad.getAllTypes();
	}

	public ArrayList<Account> getAllUnchekedAccounts() {
		return ad.getAllUnchekedAccounts();
	}

	public Boolean acceptAccount(int idAcc, int newState) {
		return ad.acceptAccount(idAcc, newState);
	}

	public ArrayList<Account> getAccountsFrom(int idClient) {
		return ad.getAccountsFrom(idClient);
	}

	public typeAccount getType(int idType) {
		return ad.getType(idType);
	}

}
