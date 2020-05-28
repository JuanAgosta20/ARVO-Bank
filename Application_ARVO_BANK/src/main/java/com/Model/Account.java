package com.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {
	Integer idAccount;
	String CBU;
	String typeAccount;
	String nameAccount;
	Float funds;
	LocalDateTime creationDate;
	ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
	Byte state;

	public Account() {
		super();
	}

	public Integer getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public String getNameAccount() {
		return nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public Float getFunds() {
		return funds;
	}

	public void setFunds(Float funds) {
		this.funds = funds;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ArrayList<Transaction> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(ArrayList<Transaction> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

}
