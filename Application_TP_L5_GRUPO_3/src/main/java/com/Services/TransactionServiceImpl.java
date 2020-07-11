package com.Services;

import java.math.BigInteger;
import java.util.ArrayList;

import com.Dao.TransactionDao;
import com.Dao.TransactionDaoImpl;
import com.Model.Transaction;
import com.Model.TransactionsPerMonth;
import com.Model.typeMove;

public class TransactionServiceImpl implements TransactionService {

	TransactionDao td;
	
	public TransactionServiceImpl(TransactionDao tdao) {
		this.td = tdao;
	}

	public Boolean insertTransaction(Transaction trans) {
		return td.insertTransaction(trans);
		}

	
	public Boolean verifyTransaction(Transaction trans) {
		return td.verifyTransaction(trans);
	}


	public ArrayList<Transaction> getAllTransactions(Integer idAccount) {
		return td.getAllTransactions(idAccount);
	}

	
	public ArrayList<Transaction> getTransactionsFrom(Integer idAccount) {
		
		return td.getTransactionsFrom(idAccount);
	}

	
	public ArrayList<Transaction> getTransactionsTo(Integer destinationAccount) {
		return td.getTransactionsTo(destinationAccount);
		
	}

	
	public typeMove getType(int idTypeMove) {
		return td.getType(idTypeMove);
	}


	public ArrayList<TransactionsPerMonth> getTransactionsBetween(String init, String end) {
		return td.getTransactionsBetween(init,end);
	}


	public ArrayList<String> getTransactionsBetweenName(String init, String end) {
		return td.getTransactionsBetweenName(init,end);
	}

	
	public ArrayList<typeMove> getAllTypes() {
		
		return td.getAllTypes();
	}

	
	
	
}
