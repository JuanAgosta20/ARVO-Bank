package com.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Countries")
public class Countrie implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idCountrie;
	String name;
	
	public Countrie() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCountrie() {
		return idCountrie;
	}

	public void setIdCountrie(int idCountrie) {
		this.idCountrie = idCountrie;
	}

}
