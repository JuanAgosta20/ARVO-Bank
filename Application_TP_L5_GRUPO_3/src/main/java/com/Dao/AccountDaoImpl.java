package com.Dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Model.Account;
import com.Model.typeAccount;

@SuppressWarnings("unchecked")
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


	public ArrayList<typeAccount> getAllTypes() {
		return (ArrayList<typeAccount>)sHand.getAllData(typeAccount.class);
	}

	public ArrayList<Account> getAllUnchekedAccounts() {
		String hql = "From Account a WHERE a.state = :id";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", 1);
		try {
			return (ArrayList<Account>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
