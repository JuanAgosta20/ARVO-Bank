package com.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeMoves")
public class typeMove implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idTypeMove;
	String description;
	Boolean credit;// true suma

	public typeMove() {
		super();
	}

	public Integer getIdTypeMove() {
		return idTypeMove;
	}

	public void setIdTypeMove(Integer idTypeMove) {
		this.idTypeMove = idTypeMove;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCredit() {
		return credit;
	}

	public void setCredit(Boolean credit) {
		this.credit = credit;
	}

}
