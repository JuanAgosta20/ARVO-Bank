package com.Services;

import java.util.ArrayList;

import com.Dao.TransactionDao;
import com.Dao.TransactionDaoImpl;
import com.Model.Transaction;
import com.Model.typeMove;

public class TransactionServiceImpl implements TransactionService {

	TransactionDao td = new TransactionDaoImpl();
	

	public Boolean insertTransaction(Transaction trans) {
		return td.insertTransaction(trans);
		}

	@Override
	public Boolean verifyTransaction(Transaction trans) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Transaction> getAllTransactions(int idAccount) {
		return td.getAllTransactions(idAccount);
	}

	@Override
	public ArrayList<Transaction> getTransactionsFrom(int idAccount) {
		
		return td.getTransactionsFrom(idAccount);
	}

	
	public ArrayList<Transaction> getTransactionsTo(int destinationAccount) {
		return td.getTransactionsTo(destinationAccount);
		
	}

	
	public typeMove getType(int idTypeMove) {
		return td.getType(idTypeMove);
	}

	
	
	
}