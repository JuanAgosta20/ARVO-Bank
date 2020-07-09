package com.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeAccounts")
public class typeAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idTypeAccount;
	String description;
	Boolean ars; // True pesos

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		typeAccount other = (typeAccount) obj;
		if (ars == null) {
			if (other.ars != null)
				return false;
		} else if (!ars.equals(other.ars))
			return false;
		return true;
	}

	public typeAccount() {
		super();
	}

	public Integer getIdTypeAccount() {
		return idTypeAccount;
	}

	public void setIdTypeAccount(Integer idTypeAccount) {
		this.idTypeAccount = idTypeAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getArs() {
		return ars;
	}

	public void setArs(Boolean ars) {
		this.ars = ars;
	}

}
