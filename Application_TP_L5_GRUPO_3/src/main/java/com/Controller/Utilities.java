package com.Controller;

import java.util.ArrayList;
import java.util.Date;

import com.Model.Account;
import com.Model.Administrative;
import com.Model.Client;
import com.Model.FeePayment;
import com.Model.Genre;
import com.Model.Loan;
import com.Model.Transaction;
import com.Model.User;
import com.Model.typeAccount;
import com.Model.typeMove;

public class Utilities {

	public Utilities() {
		super();
	}

	public static Account createAccount(String cbu, Date date, Float funds, String name, Byte state,
			ArrayList<Transaction> tm, ArrayList<Transaction> tr, typeAccount type) {
		Account acc = new Account();
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
	
	public static typeAccount createTypeAccount(String desc) {
		typeAccount ta = new typeAccount();
		ta.setDescription(desc);
		return ta;
	}
	
	public static typeMove createTypeMove(String desc, Boolean credit) {
		typeMove tm = new typeMove();
		tm.setCredit(credit);
		tm.setDescription(desc);
		return tm;
	}

	public static Client createClient(Date birthdate, String city, String dni, String email, String fName, String lName,
			String nationality, String province, Genre genre, User user, ArrayList<Account> bankAccounts) {
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
		cl.setBankAccounts(bankAccounts);

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

	public static Transaction createTransaction(Float amm, String concept, Date date, Account oa, Account da, typeMove tm) {
		Transaction trans = new Transaction();

		trans.setAmmount(amm);
		trans.setConcept(concept);
		trans.setDate(date);
		trans.setState((byte) 1);
		trans.setOriginAccount(oa);
		trans.setDestinationAccount(da);
		trans.setTm(tm);

		return trans;
	}

	public static Loan createLoan(Client client, Float ammount, Date date, Integer fees, Float monthAmmount) {
		Loan loan = new Loan();
		loan.setClient(client);
		loan.setAmmount(ammount);
		loan.setDate(date);
		loan.setFees(fees);
		loan.setState((byte) 1);
		loan.setMonthAmmount(monthAmmount);

		return loan;
	}

	public static FeePayment creatFeePayment(Float ammount, Date date) {
		FeePayment fp = new FeePayment();
		fp.setAmmount(ammount);
		fp.setDate(date);
		fp.setState((byte) 1);

		return fp;
	}
}
