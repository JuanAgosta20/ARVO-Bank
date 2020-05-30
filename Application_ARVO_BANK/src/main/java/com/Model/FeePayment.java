package com.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Feepayment")
public class FeePayment {
	@Id
	Integer loanId;
	@Column(columnDefinition="datetime not null")
	Date date;

	public FeePayment() {
		super();
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
