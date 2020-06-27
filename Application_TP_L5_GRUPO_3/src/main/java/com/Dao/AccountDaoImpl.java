package com.Dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.Account;
import com.Model.Connection;
import com.Model.typeAccount;

public class AccountDaoImpl implements AccountDao{

	SessionHandler sHand = new SessionHandler();
	Session session;

	public AccountDaoImpl() {
		super();
		session = sHand.getSession();
	}

	public void Destroy() {
		sHand.close();
	}
	
	public Boolean insertAccount(Account acc) {
		try {
			sHand.save(acc);
			sHand.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteAccount(Account acc) {
		try {
			acc.setState((byte)0);
			sHand.update(acc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<typeAccount> getAllTypes() {
		return (ArrayList<typeAccount>)sHand.getAllData(typeAccount.class);
	}

}
