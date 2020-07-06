package com.Services;

import java.util.ArrayList;

import com.Dao.LoanDao;
import com.Dao.LoanDaoImpl;
import com.Model.Loan;

public class LoanServiceImpl implements LoanService{

	LoanDao ld = new LoanDaoImpl(); //CAMBIAR POR BEAN
	
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

}