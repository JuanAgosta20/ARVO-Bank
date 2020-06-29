package com.Dao;

import java.util.ArrayList;

import com.Model.Account;
import com.Model.typeAccount;

public interface AccountDao {
	public Boolean insertAccount(Account acc);
	public Boolean deleteAccount(Account acc);
	public Boolean updateStateAccount(int idAcc, int newState);
	public ArrayList<Account> getAccountsFrom(int idClient);
	public ArrayList<Account> getAllUnchekedAccounts();
	public ArrayList<typeAccount> getAllTypes();
}
