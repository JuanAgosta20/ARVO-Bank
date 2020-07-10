package com.Services;

import java.util.ArrayList;

import com.Model.Loan;

public interface LoanService {
	public Boolean insertLoan(Loan loan);
	public Boolean deleteLoan(int idLoan);
	public Boolean acceptLoan(int idL, int newState);
	public ArrayList<Loan> getLoansFrom(int idClient);
	public ArrayList<Loan> getAllUnchekedLoans();
	public Boolean Payment(int idLoan, int idFeePayment);
	public Loan getLoan(int idLoan);
}
