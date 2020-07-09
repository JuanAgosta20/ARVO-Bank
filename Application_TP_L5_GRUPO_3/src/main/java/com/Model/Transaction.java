package com.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrans;
	private Float ammount;
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "originAccount")
	private Account originAccount;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destinationAccount")
	private Account destinationAccount;
	private String concept;
	private Byte state;
	@ManyToOne()
	@JoinColumn(name = "idTypeMove")
	private typeMove tm;
private Float history;

	
	public Transaction() {
		super();
	}

	public Float getAmmount() {
		return ammount;
	}

	public void setAmmount(Float ammount) {
		this.ammount = ammount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Integer getIdTrans() {
		return idTrans;
	}

	public void setIdTrans(Integer idTrans) {
		this.idTrans = idTrans;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public Account getOriginAccount() {
		return originAccount;
	}

	public void setOriginAccount(Account originAccount) {
		this.originAccount = originAccount;
	}

	public typeMove getTm() {
		return tm;
	}

	public void setTm(typeMove tm) {
		this.tm = tm;
	}

	public Float getHistory() {
		return history;
	}

	public void setHistory(Float history) {
		this.history = history;
	}
	
	

}
