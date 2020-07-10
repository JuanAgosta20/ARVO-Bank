package com.Services;

import java.math.BigInteger;
import java.util.ArrayList;

import com.Model.Transaction;

import com.Model.typeMove;

public interface TransactionService {

	public Boolean insertTransaction(Transaction trans);
	public Boolean verifyTransaction (Transaction trans); //verifica que se cumplan los requisitos
	public ArrayList<Transaction> getAllTransactions(int idAccount);
	public ArrayList<Transaction> getTransactionsFrom(int idAccount);
	public ArrayList<Transaction> getTransactionsTo(int destinationAccount);
	public typeMove getType(int idTypeMove);
	public ArrayList<BigInteger> getTransactionsBetween(String init, String end);
	public ArrayList<String> getTransactionsBetweenName(String init, String end);
	
}
