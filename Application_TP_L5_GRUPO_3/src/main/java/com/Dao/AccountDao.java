package com.Dao;

import java.util.ArrayList;

import com.Model.Account;
import com.Model.typeAccount;

public interface AccountDao {
	public Boolean insertAccount(Account acc);
	public Boolean deleteAccount(Account acc);
	public ArrayList<typeAccount> getAllTypes();
}
