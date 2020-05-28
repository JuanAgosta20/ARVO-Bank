package com.Model;

import java.time.LocalDateTime;

public class FeePayment {
	Integer loanId;
	LocalDateTime date;

	public FeePayment() {
		super();
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
