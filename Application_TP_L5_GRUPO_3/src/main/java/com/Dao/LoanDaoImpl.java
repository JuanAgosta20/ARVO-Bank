package com.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Cmd;
import com.Model.Loan;
import com.Model.FeePayment;

public class LoanDaoImpl implements LoanDao {

	SessionHandler sh;

	public Boolean insertLoan(Loan loan) {
		try {
			sh = new SessionHandler();
			sh.save(loan);
			sh.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteLoan(int idLoan) {
		try {
			sh = new SessionHandler();
			Loan loan = (Loan) sh.get(Loan.class, idLoan);
			loan.setState(0);
			sh.update(loan);
			sh.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean acceptLoan(int idL, int newState) {
		try {
			sh = new SessionHandler();
			Loan loan = (Loan)sh.get(Loan.class, idL);
			loan.setState(newState);
			loan.setDate(Cmd.crearFecha());
			LocalDate date = Cmd.crearFecha(loan.getDate());
			ArrayList<FeePayment> payments = new ArrayList<FeePayment>();
			for (int i = 1; i <= loan.getFees(); i++) {
				FeePayment fp = new FeePayment();
				fp.setDate(Cmd.crearFecha(date.plusMonths(i)));
				fp.setState(0);
				fp.setAmmount(0f);
				payments.add(fp);
			}
			loan.setPayments(payments);
			sh.update(loan);
			sh.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Loan> getLoansFrom(int idClient) {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Loan l WHERE l.client.idClient = :id";
			Query query = (Query) session.createQuery(hql);
			query.setParameter("id", idClient);
			return (ArrayList<Loan>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Loan> getAllUnchekedLoans() {
		try {
			sh = new SessionHandler();
			Session session = sh.getSession();
			String hql = "From Loan l WHERE l.state = 1";
			Query query = (Query) session.createQuery(hql);
			return (ArrayList<Loan>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
