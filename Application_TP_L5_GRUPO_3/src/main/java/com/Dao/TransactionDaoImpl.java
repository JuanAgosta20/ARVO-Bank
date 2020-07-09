package com.Dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Account;
import com.Model.Transaction;
import com.Model.typeMove;

public class TransactionDaoImpl implements TransactionDao {
	
	
	SessionHandler sh;
	
	
	
public Boolean insertTransaction(Transaction trans) {
		
		try {
			sh = new SessionHandler();
			sh.save(trans);
			sh.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	
	public Boolean verifyTransaction(Transaction trans) {
		try {
		sh = new SessionHandler();
		Account acc = (Account)sh.get(Account.class, trans.getOriginAccount().getIdAccount());
			
		if (acc.getFunds() >= trans.getAmmount() && acc.getState()==2) {
			return true;
		}
		else return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			sh.close();
		}
		
	}


	public ArrayList<Transaction> getTransactionsFrom(int originAccount) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Transaction t WHERE t.originAccount = :originAccount";
			Query query = (Query) session.createQuery(hql);
			query.setParameter("originAccount", originAccount);
			return (ArrayList<Transaction>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	
	public ArrayList<Transaction> getTransactionsTo(int destinationAccount) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Transaction t WHERE t.destinationAccount = :destinationAccount";
			Query query = (Query) session.createQuery(hql);
			query.setParameter("destinationAccount", destinationAccount);
			return (ArrayList<Transaction>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Transaction> getAllTransactions(int idAccount) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Transaction t WHERE t.destinationAccount = :idAccount or t.originAccount = :idAccount";
			Query query = (Query) session.createQuery(hql);
			query.setParameter("idAccount", idAccount);
			return (ArrayList<Transaction>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	public typeMove getType(int idTypeMove) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			return (typeMove)sh.get(typeMove.class, idTypeMove);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
