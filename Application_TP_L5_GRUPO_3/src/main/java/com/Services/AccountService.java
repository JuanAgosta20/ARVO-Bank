package com.Services;

import java.util.ArrayList;

import com.Model.Account;
import com.Model.typeAccount;

public interface AccountService {

	public Boolean insertAccount(Account acc);
	public Boolean deleteAccount(Account acc);
	public ArrayList<Account> getAllUnchekedAccounts();
	public ArrayList<typeAccount> getAllTypes();
	
}
