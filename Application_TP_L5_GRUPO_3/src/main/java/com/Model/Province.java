package com.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="provinces")
public class Province implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idProvince;
	@Column(unique = true)
	int idProvinceApi;
	@Column(unique = true)
	String name;
	
	public Province() {
		super();
	}

	public int getIdProvinceApi() {
		return idProvinceApi;
	}

	public void setIdProvinceApi(int idProvinceApi) {
		this.idProvinceApi = idProvinceApi;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getIdProvince() {
		return idProvince;
	}

	public void setIdProvince(int idProvince) {
		this.idProvince = idProvince;
	}
	
	
}
