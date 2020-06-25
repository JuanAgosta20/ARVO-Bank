package com.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Genres")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idGenre;
	String description;
	
	public Genre() {
		super();
	}
	public int getIdGenre() {
		return idGenre;
	}
	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
