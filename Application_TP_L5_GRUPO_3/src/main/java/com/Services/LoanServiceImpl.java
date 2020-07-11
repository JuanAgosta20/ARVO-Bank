package com.Services;

import java.util.ArrayList;

import com.Dao.LoanDao;
import com.Model.Loan;

public class LoanServiceImpl implements LoanService{

	LoanDao ld;
	
	public LoanServiceImpl(LoanDao ldao) {
		this.ld = ldao;
	}
	
	public Boolean insertLoan(Loan loan) {
		return ld.insertLoan(loan);
	}

	public Boolean deleteLoan(int idLoan) {
		return ld.deleteLoan(idLoan);
	}

	public Boolean acceptLoan(int idL, int newState) {
		return ld.acceptLoan(idL, newState);
	}

	public ArrayList<Loan> getLoansFrom(int idClient) {
		return ld.getLoansFrom(idClient);
	}

	public ArrayList<Loan> getAllUnchekedLoans() {
		return ld.getAllUnchekedLoans();
	}

	public Boolean Payment(int idLoan, int idFeePayment) {
		return ld.Payment(idLoan, idFeePayment);
	}

	public Loan getLoan(int idLoan) {
		return ld.getLoan(idLoan);
	}

}
