package com.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrans;
	private Float ammount;
	private Date date;
	private Integer originAccount;
	private Integer destinationAccount;
	private String concept;
	private Byte state;

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

	public Integer getIdTrans() {
		return idTrans;
	}

	public void setIdTrans(Integer idTrans) {
		this.idTrans = idTrans;
	}

}
