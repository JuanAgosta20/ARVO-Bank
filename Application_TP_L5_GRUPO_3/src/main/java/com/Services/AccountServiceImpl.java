package com.Services;

import java.util.ArrayList;

import com.Dao.AccountDao;
import com.Model.Account;
import com.Model.typeAccount;

public class AccountServiceImpl implements AccountService{

	AccountDao ad;
	
	public AccountServiceImpl(AccountDao adao) {
		this.ad = adao;
	}
	
	public Boolean insertAccount(Account acc) {
		return ad.insertAccount(acc);
	}

	public Boolean deleteAccount(int idAccount) {
		return ad.deleteAccount(idAccount);
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


	public Account getAccount(String CBU) {
		
		return ad.getAccount(CBU);
	}

	
	public Boolean checkCompatibility(String CBUFrom, String CBUTo) {
	
		return ad.checkCompatibility(CBUFrom, CBUTo);
	}

	
	public Boolean updateAccount(Account account) {
		
		return ad.updateAccount(account);
	}

	
	public Boolean updateFunds(int idAcc, float funds) {
		
		return ad.updateFunds(idAcc, funds);
	}

	
	public Account getMasterAccount(Boolean ars) {
		// TODO Auto-generated method stub
		return ad.getMasterAccount(ars);
	}

}
