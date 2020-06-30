package com.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="cities")
public class City implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	String idCity;
	@Column(unique = true)
	String name;
	@ManyToOne()
	@JoinColumn(name = "idProvince")
	Province prov;
	
	public City() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCity() {
		return idCity;
	}

	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}

	public Province getProv() {
		return prov;
	}

	public void setProv(Province prov) {
		this.prov = prov;
	}
	
}
