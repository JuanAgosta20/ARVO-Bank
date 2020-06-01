package com.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Loans")
public class Loan implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer loanId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente")
	Client client;
	Date date;
	Float ammount;
	// Consultar a tamara cuotas y plazo de pago en meses;
	Integer fees;
	Float monthAmmount;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanId")
	List<FeePayment> payments;

	public Loan() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getAmmount() {
		return ammount;
	}

	public void setAmmount(Float ammount) {
		this.ammount = ammount;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Float getMonthAmmount() {
		return monthAmmount;
	}

	public void setMonthAmmount(Float monthAmmount) {
		this.monthAmmount = monthAmmount;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public List<FeePayment> getPayments() {
		return payments;
	}

	public void setPayments(List<FeePayment> payments) {
		this.payments = payments;
	}
	

}
