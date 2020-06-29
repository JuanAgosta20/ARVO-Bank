package com.Dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Model.Account;
import com.Model.typeAccount;

@SuppressWarnings("unchecked")
public class AccountDaoImpl implements AccountDao{

	SessionHandler sHand;

	public AccountDaoImpl() {
		super();
	}

	public void Destroy() {
		sHand.close();
	}
	
	public Boolean insertAccount(Account acc) {
		try {
			sHand = new SessionHandler();
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
			sHand = new SessionHandler();
			acc.setState(0);
			sHand.update(acc);
			sHand.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public ArrayList<typeAccount> getAllTypes() {
		sHand = new SessionHandler();
		return (ArrayList<typeAccount>)sHand.getAllData(typeAccount.class);
	}

	public ArrayList<Account> getAllUnchekedAccounts() {
		sHand = new SessionHandler();
		Session session = sHand.getSession();
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

	public Boolean updateStateAccount(int idAcc, int newState) {
		try {
			sHand = new SessionHandler();
			Account acc = (Account)sHand.get(Account.class, idAcc);
			acc.setState(newState);
			sHand.update(acc);
			sHand.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public ArrayList<Account> getAccountsFrom(int idClient) {
		sHand = new SessionHandler();
		Session session = sHand.getSession();
		String hql = "From Account a WHERE a.client.idClient = :id AND a.state = 2";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", idClient);
		try {
			return (ArrayList<Account>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
