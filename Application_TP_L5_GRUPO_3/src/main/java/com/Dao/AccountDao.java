package com.Dao;

import java.util.ArrayList;

import com.Model.Account;
import com.Model.typeAccount;

public interface AccountDao {
	public Boolean insertAccount(Account acc);
	public Boolean deleteAccount(int idAccount);
	public Boolean acceptAccount(int idAcc, int newState);
	public Boolean updateAccount(Account account);
	public Boolean updateFunds(int idAcc, float funds);
	public Boolean checkCompatibility(String CBUFrom, String CBUTo);
	public Account getAccount(String CBU);
	public Account getMasterAccount(Boolean ars);
	public ArrayList<Account> getAccountsFrom(int idClient);
	public ArrayList<Account> getAllUnchekedAccounts();
	public int getCountAccounts(int idClient);
	public ArrayList<typeAccount> getAllTypes();
	public typeAccount getType(int idType);
	
}
