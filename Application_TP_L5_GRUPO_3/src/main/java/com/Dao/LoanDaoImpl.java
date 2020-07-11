package com.Dao;

import java.time.LocalDate;
import java.util.ArrayList;

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
			sh.close();
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
			sh.close();
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
				fp.setnPayment(i);
				fp.setDate(Cmd.crearFecha(date.plusMonths(i)));
				fp.setState(0);
				fp.setAmmount(loan.getMonthAmmount());
				payments.add(fp);
			}
			loan.setPayments(payments);
			sh.update(loan);
			sh.commit();
			sh.close();
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
		}finally {
			sh.close();
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
		}finally {
			sh.close();
		}
	}

	public Boolean Payment(int idLoan, int idFeePayment) {
		try {
			sh = new SessionHandler();
			Loan loan = (Loan) sh.get(Loan.class, idLoan);
			Boolean loanFinish = true;
			for (FeePayment fp : loan.getPayments()) {
				if(fp.getFeePaymentId().equals(idFeePayment)) {
					fp.setState(1);
				}
				if(fp.getState().equals(0)) {
					loanFinish = false;
					break;
				}
			}
			if(loanFinish) {
				loan.setState(3);
			}
			sh.update(loan);
			sh.commit();
			sh.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Loan getLoan(int idLoan) {
		try {
			sh = new SessionHandler();
			return (Loan)sh.get(Loan.class, idLoan);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sh.close();
		}
	}

}
