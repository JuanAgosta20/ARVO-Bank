package com.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Feepayment")
public class FeePayment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feePaymentId;
	@Column
	private Date date;
	Float ammount;
	private Integer state;
	private int nPayment;

	public FeePayment() {
		super();
	}

	public Integer getFeePaymentId() {
		return feePaymentId;
	}

	public void setFeePaymentId(Integer feePaymentId) {
		this.feePaymentId = feePaymentId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public int getnPayment() {
		return nPayment;
	}

	public void setnPayment(int nPayment) {
		this.nPayment = nPayment;
	}
	
}
