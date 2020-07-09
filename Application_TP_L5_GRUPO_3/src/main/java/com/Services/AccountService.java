package com.Services;

import java.util.ArrayList;

import com.Model.Account;
import com.Model.typeAccount;

public interface AccountService {

	public Boolean insertAccount(Account acc);
	public Boolean deleteAccount(int idAccount);
	public Boolean acceptAccount(int idAcc, int newState);
	public Boolean updateAccount(Account account);
	public Boolean updateFunds(int idAcc, float funds);
	public ArrayList<Account> getAccountsFrom(int idClient);
	public ArrayList<Account> getAllUnchekedAccounts();
	public ArrayList<typeAccount> getAllTypes();
	public typeAccount getType(int idType);
	public Account getAccount(String CBU);
	public Account getMasterAccount(Boolean ars); // true para pesos, false dolares
	public Boolean checkCompatibility(String CBUFrom, String CBUTo);
}
