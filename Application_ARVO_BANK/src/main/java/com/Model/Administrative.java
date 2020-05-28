package com.Model;

public class Administrative {
	User user = new User();
	Integer id_administrative;
	String first_name;
	String last_name;
	String dni;
	String email;
	Byte state;

	public Administrative() {
		super();
	}

	public Integer getId_administrative() {
		return id_administrative;
	}

	public void setId_administrative(Integer id_administrative) {
		this.id_administrative = id_administrative;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

}
