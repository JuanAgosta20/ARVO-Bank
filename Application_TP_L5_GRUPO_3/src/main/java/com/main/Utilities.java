package com.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Model.Account;
import com.Model.Administrative;
import com.Model.City;
import com.Model.Client;
import com.Model.Countrie;
import com.Model.FeePayment;
import com.Model.Genre;
import com.Model.Loan;
import com.Model.Province;
import com.Model.Transaction;
import com.Model.User;
import com.Model.typeAccount;
import com.Model.typeMove;
import com.google.gson.Gson;

public class Utilities {

	public Utilities() {
		super();
	}

	public static Account createAccount(Client client, String cbu, Date date, Float funds, String name, int state,
			ArrayList<Transaction> tm, ArrayList<Transaction> tr, typeAccount type) {
		Account acc = new Account();
		acc.setClient(client);
		acc.setCBU(cbu);
		acc.setCreationDate(date);
		acc.setFunds(funds);
		acc.setNameAccount(name);
		acc.setState(state);
		acc.setTransactionMade(tm);
		acc.setTransactionReceived(tr);
		acc.setTypeAcc(type);

		return acc;
	}
	
	public static typeAccount createTypeAccount(String desc, Boolean ars) {
		typeAccount ta = new typeAccount();
		ta.setDescription(desc);
		ta.setArs(ars);
		return ta;
	}
	
	public static Countrie createCountrie(String name) {
		Countrie c = new Countrie();
		c.setName(name);
		return c;
	}
	
	public static Province createProvince(String name, int idProvinceApi) {
		Province p = new Province();
		p.setName(name);
		p.setIdProvinceApi(idProvinceApi);
		return p;
	}
	
	public static City createCity(String id, String name, Province prov) {
		City i = new City();
		i.setIdCity(id);
		i.setName(name);
		i.setProv(prov);
		return i;
	}
	
	public static typeMove createTypeMove(String desc, Boolean credit) {
		typeMove tm = new typeMove();
		tm.setCredit(credit);
		tm.setDescription(desc);
		return tm;
	}

	public static Client createClient(Date birthdate, City city, String dni, String email, String fName, String lName,
			Countrie nationality, Province province, Genre genre, User user) {
		Client cl = new Client();

		cl.setBirthdate(birthdate);
		cl.setCity(city);
		cl.setDni(dni);
		cl.setEmail(email);
		cl.setFirstName(fName);
		cl.setLastName(lName);
		cl.setNationality(nationality);
		cl.setProvince(province);
		cl.setGenre(genre);
		cl.setState((byte) 1);
		cl.setUser(user);

		return cl;
	}
	
	public static Genre createGenre(String desc) {
		Genre gen = new Genre();
		gen.setDescription(desc);
		return gen;
	}

	public static Administrative createAdministrative(String dni, String email, String fn, String ln, User user) {
		Administrative adm = new Administrative();

		adm.setDni(dni);
		adm.setEmail(email);
		adm.setFirst_name(fn);
		adm.setLast_name(ln);
		adm.setState((byte) 1);
		adm.setUser(user);

		return adm;
	}

	public static User createUser(String pass, String uName, String userType) {
		User user = new User();

		user.setPassword(pass);
		user.setUserName(uName);
		user.setUserType(userType);
		user.setState((byte) 1);

		return user;
	}

	public static Transaction createTransaction(Float amm, String concept, Date date, Account oa, Account da, typeMove tm, Float history) {
		Transaction trans = new Transaction();

		trans.setAmmount(amm);
		trans.setConcept(concept);
		trans.setDate(date);
		trans.setState((byte) 1);
		trans.setOriginAccount(oa);
		trans.setDestinationAccount(da);
		trans.setTm(tm);
		trans.setHistory(history);
		return trans;
	}

	public static Loan createLoan(Client client, Float ammount, Date date, Integer fees, Float monthAmmount) {
		Loan loan = new Loan();
		loan.setClient(client);
		loan.setAmmount(ammount);
		loan.setDate(date);
		loan.setFees(fees);
		loan.setState(0);
		loan.setMonthAmmount(monthAmmount);

		return loan;
	}

	public static FeePayment creatFeePayment(Float ammount, Date date) {
		FeePayment fp = new FeePayment();
		fp.setAmmount(ammount);
		fp.setDate(date);
		fp.setState(1);

		return fp;
	}
	
	public static String listToJSON(List<?> list) {
		Gson gson = new Gson();
		
		String jsonString = gson.toJson(list);
		
		return jsonString;
	}
}
