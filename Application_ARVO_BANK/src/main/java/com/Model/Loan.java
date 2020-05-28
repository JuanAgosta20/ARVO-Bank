package com.Model;

import java.time.LocalDateTime;

public class Loan {
	Integer loanId;
	Client client;
	LocalDateTime date;
	Float ammount;
	// Consultar a tamara cuotas y plazo de pago en meses;
	Integer fees;
	Float monthAmmount;

	public Loan() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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

}
