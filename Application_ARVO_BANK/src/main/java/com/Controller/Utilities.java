package com.Controller;

import java.util.ArrayList;
import java.util.Date;

import com.Model.Account;
import com.Model.Client;
import com.Model.Transaction;
import com.Model.User;

public class Utilities {

	public Utilities() {
		super();
	}

	public Account createAccount(String cbu, Date date, Float funds, String name, Byte state, ArrayList<Transaction> th,
			String type) {
		Account acc = new Account();
		acc.setCBU(cbu);
		acc.setCreationDate(date);
		acc.setFunds(funds);
		acc.setNameAccount(name);
		acc.setState(state);
		acc.setTransactionHistory(th);
		acc.setTypeAccount(type);

		return acc;
	}

	public Client createClient(Date birthdate, String city, String dni, String email, String fName, String lName,
			String nationality, String province, boolean sex, Byte state, User user, ArrayList<Account> bankAccounts) {
		Client cl = new Client();

		cl.setBirthdate(birthdate);
		cl.setCity(city);
		cl.setDni(dni);
		cl.setEmail(email);
		cl.setFirstName(fName);
		cl.setLastName(lName);
		cl.setNationality(nationality);
		cl.setProvince(province);
		cl.setSex(sex);
		cl.setState(state);
		cl.setUser(user);
		cl.setBankAccounts(bankAccounts);

		return cl;
	}

	public User createUser(String pass, String uName, String userType, Byte state) {
		User user = new User();

		user.setPassword(pass);
		user.setUserName(uName);
		user.setUserType(userType);
		user.setState(state);

		return user;
	}

	public Transaction createTransaction(Float amm, String concept, Date date, Integer destinationAccount,
			Integer originAccount, Byte state) {
		Transaction trans = new Transaction();

		trans.setAmmount(amm);
		trans.setConcept(concept);
		trans.setDate(date);
		trans.setDestinationAccount(destinationAccount);
		trans.setOriginAccount(originAccount);
		trans.setState(state);

		return trans;
	}
}
