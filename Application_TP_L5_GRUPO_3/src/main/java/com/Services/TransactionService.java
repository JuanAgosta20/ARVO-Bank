package com.Services;

import java.math.BigInteger;
import java.util.ArrayList;

import com.Model.Transaction;
import com.Model.TransactionsPerMonth;
import com.Model.typeMove;

public interface TransactionService {

	public Boolean insertTransaction(Transaction trans);
	public Boolean verifyTransaction (Transaction trans); //verifica que se cumplan los requisitos
	public ArrayList<Transaction> getAllTransactions(Integer idAccount);
	public ArrayList<Transaction> getTransactionsFrom(Integer idAccount);
	public ArrayList<Transaction> getTransactionsTo(Integer destinationAccount);
	public typeMove getType(int idTypeMove);
	public ArrayList<TransactionsPerMonth> getTransactionsBetween(String init, String end);
	public ArrayList<String> getTransactionsBetweenName(String init, String end);
	public ArrayList<typeMove>getAllTypes();
}
