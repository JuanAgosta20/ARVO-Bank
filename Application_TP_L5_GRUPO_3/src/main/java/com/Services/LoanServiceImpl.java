package com.Services;

import java.util.ArrayList;

import com.Dao.LoanDao;
import com.Dao.LoanDaoImpl;
import com.Model.Loan;

public class LoanServiceImpl implements LoanService{

	LoanDao ld = new LoanDaoImpl(); //CAMBIAR POR BEAN
	
	@Override
	public Boolean insertLoan(Loan loan) {
		return ld.insertLoan(loan);
	}

	@Override
	public Boolean deleteLoan(int idLoan) {
		return ld.deleteLoan(idLoan);
	}

	@Override
	public Boolean acceptLoan(int idL, int newState) {
		return ld.acceptLoan(idL, newState);
	}

	@Override
	public ArrayList<Loan> getLoansFrom(int idClient) {
		return ld.getLoansFrom(idClient);
	}

	@Override
	public ArrayList<Loan> getAllActiveLoans() {
		return ld.getAllActiveLoans();
	}

}
