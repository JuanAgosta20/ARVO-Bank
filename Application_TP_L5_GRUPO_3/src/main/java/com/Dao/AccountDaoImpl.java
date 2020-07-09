package com.Dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Model.Account;
import com.Model.Cmd;
import com.Model.typeAccount;

@SuppressWarnings("unchecked")
public class AccountDaoImpl implements AccountDao{

	SessionHandler sHand;

	public AccountDaoImpl() {
		super();
	}

	public void Destroy() {
		if(sHand.session.isOpen())
		sHand.close();
	}
	
	public Boolean insertAccount(Account acc) {
		try {
			sHand = new SessionHandler();
			sHand.save(acc);
			sHand.commit();
			sHand.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteAccount(int idAccount) {
		try {
			sHand = new SessionHandler();
			Account acc = (Account) sHand.get(Account.class, idAccount);
			acc.setState(0);
			sHand.update(acc);
			sHand.commit();
			sHand.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public ArrayList<typeAccount> getAllTypes() {
		try {
			sHand = new SessionHandler();
			return (ArrayList<typeAccount>)sHand.getAllData(typeAccount.class);
		} finally {
			sHand.close();
		}	
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
		}finally {
			sHand.close();
		}
	}

	public Boolean acceptAccount(int idAcc, int newState) {
		try {
			sHand = new SessionHandler();
			Account acc = (Account)sHand.get(Account.class, idAcc);
			acc.setState(newState);
			int accCount = getCountAccounts(acc.getClient().getIdClient());
			if(accCount == -1 || accCount >= 4)
				throw new Exception();
			acc.setCBU(Cmd.crearCBU(acc.getClient().getDni()));
			acc.setFunds(0f);
			acc.setNameAccount("Cuenta Nro " + (accCount + 1));
			sHand.update(acc);
			sHand.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			sHand.close();
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
		}finally {
			sHand.close();
		}
	}

	public typeAccount getType(int idType) {
		try {
			sHand = new SessionHandler();
			return (typeAccount)sHand.get(typeAccount.class, idType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sHand.close();
		}
	}

	public int getCountAccounts(int idClient) {
		Session session = sHand.getSession();
		String hql = "select count(a) From Account a WHERE a.client.idClient = :id AND a.state = 2";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("id", idClient);
		try {
			return ((Number)query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}




	public Account getAccount(String CBU) {
		try {
			sHand = new SessionHandler();
			Session session = sHand.getSession();
			String hql = "From Account acc WHERE acc.CBU = :CBU";
			Query query = (Query) session.createQuery(hql);
			query.setParameter("CBU", CBU);
			return (Account) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public Boolean checkCompatibility(String CBUFrom, String CBUTo) {
		Account accFrom = getAccount(CBUFrom);
		Account accTo = getAccount(CBUTo);
		
		if (accFrom.getTypeAcc().equals(accTo.getTypeAcc())) {
			return true;
		}
		
		else return false;
	}


	public Boolean updateAccount(Account account) {
		sHand = new SessionHandler();
		try {
			sHand.update(account);
			sHand.commit();
			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	public Boolean updateFunds(int idAcc, float funds) {
		try {
			sHand = new SessionHandler();
			Account acc = (Account)sHand.get(Account.class, idAcc);
			acc.setFunds(funds);
			sHand.update(acc);
			sHand.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
	}
		}

	
	public Account getMasterAccount(Boolean ars) {
		try {
			sHand = new SessionHandler();
			Session session = sHand.getSession();
			if(ars) {
			String hql = "From Account acc WHERE acc.idAccount = 1";
			Query query = (Query) session.createQuery(hql);
			
			return (Account) query.uniqueResult();
			}
			else {
				String hql = "From Account acc WHERE acc.idAccount = 2";
				Query query = (Query) session.createQuery(hql);
				
				return (Account) query.uniqueResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		
	}


}
