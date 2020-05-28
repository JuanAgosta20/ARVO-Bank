package com.Model;

import java.time.LocalDateTime;

public class Transaction {
	Float ammount;
	LocalDateTime date;
	Integer originAccount;
	Integer destinationAccount;
	String concept;
	Byte state;

	public Transaction() {
		super();
	}

	public Float getAmmount() {
		return ammount;
	}

	public void setAmmount(Float ammount) {
		this.ammount = ammount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getOriginAccount() {
		return originAccount;
	}

	public void setOriginAccount(Integer originAccount) {
		this.originAccount = originAccount;
	}

	public Integer getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Integer destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

}
