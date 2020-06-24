package com.Dao;

import com.Model.Account;

public interface AccountDao {
	public Boolean insertAccount(Account acc);
	public Boolean deleteAccount(Account acc);
}
