package com.Dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Account;
import com.Model.Transaction;
import com.Model.TransactionsPerMonth;
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
			Account acc = (Account) sh.get(Account.class, trans.getOriginAccount().getIdAccount());

			if (acc.getFunds() >= trans.getAmmount() && acc.getState() == 2) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sh.close();
		}

	}

	public ArrayList<Transaction> getTransactionsFrom(Integer originAccount) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Transaction t WHERE t.originAccount.idAccount = :originAccount";
			Query query = (Query) session.createQuery(hql);
			query.setParameter("originAccount", originAccount);
			return (ArrayList<Transaction>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Transaction> getTransactionsTo(Integer destinationAccount) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Transaction t WHERE t.destinationAccount.idAccount = :destinationAccount";
			Query query = (Query) session.createQuery(hql);
			query.setParameter("destinationAccount", destinationAccount);
			return (ArrayList<Transaction>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Transaction> getAllTransactions(Integer idAccount) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Transaction t WHERE (t.destinationAccount.idAccount = :idAccount and t.tm.idTypeMove!=3) or (t.originAccount.idAccount = :idAccount and t.tm.idTypeMove!=4) ORDER BY t.idTrans desc";
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
			return (typeMove) sh.get(typeMove.class, idTypeMove);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<TransactionsPerMonth> getTransactionsBetween(String init, String end) {
		sh = new SessionHandler();
		Session session = sh.getSession();
		String hql = "SELECT DATE_FORMAT(date, '%M') as 'monthName', COUNT(idTrans) as 'quantity' FROM transactions where (date BETWEEN '" + init +"' AND '"+end+"') group by DATE_FORMAT(date, '%m') Order by DATE_FORMAT(date, '%m');";
		return (ArrayList<TransactionsPerMonth>) session.createSQLQuery(hql).list();
	}

	public ArrayList<String> getTransactionsBetweenName(String init, String end) {
		sh = new SessionHandler();
		Session session = sh.getSession();
		String hql = "SELECT DATE_FORMAT(date, '%M') as 'monthName' FROM transactions where (date BETWEEN '" + init
				+ "' AND '" + end + "') group by DATE_FORMAT(date, '%m') Order by DATE_FORMAT(date, '%m')";
		return (ArrayList<String>) session.createSQLQuery(hql).list();
	}

	
	public ArrayList<typeMove> getAllTypes() {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			return (ArrayList<typeMove>)sh.getAllData(typeMove.class);
		} finally {
			sh.close();
		}	
	}

}
