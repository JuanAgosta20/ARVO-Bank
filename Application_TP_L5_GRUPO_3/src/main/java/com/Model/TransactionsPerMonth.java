package com.Model;

import java.math.BigInteger;

public class TransactionsPerMonth {
	private String monthName;
	private BigInteger quantity;
	public TransactionsPerMonth() {
		super();
	}
	public BigInteger getQuantity() {
		return quantity;
	}
	public void setQuantity(BigInteger integer) {
		this.quantity = integer;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public TransactionsPerMonth(String monthName, BigInteger quantity) {
		super();
		this.monthName = monthName;
		this.quantity = quantity;
	}
	
	

}
