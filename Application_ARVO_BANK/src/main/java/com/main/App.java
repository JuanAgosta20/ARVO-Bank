package com.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.Account;
import com.Model.Client;
import com.Model.Connection;
import com.Model.Transaction;
import com.Model.User;

public class App {

	public static void main(String[] args) {

		SessionFactory sf = Connection.getInstance();
		Session session = sf.openSession();
		session.beginTransaction();

		// USUARIO
		User user = new User();
		user.setUserName("Carlos");
		user.setPassword("123456");
		user.setState((byte) 1);
		user.setUserType("Cliente");

		// TRANSACCION
		Transaction trans = new Transaction();
		trans.setAmmount(200F);
		trans.setConcept("Pagos");
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 5, 12);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 12);
		cal.set(Calendar.SECOND, 33);
		trans.setDate(cal.getTime());
		ArrayList<Transaction> hisTrans = new ArrayList<Transaction>();
		hisTrans.add(trans);

		// CUENTA
		Account acc = new Account();
		acc.setCBU("12321323213");
		acc.setCreationDate(new Date());
		acc.setFunds(32323.4F);
		acc.setNameAccount("Cuenta 1");
		acc.setState((byte) 1);
		acc.setTypeAccount("Caja de ahorro");
		acc.setTransactionHistory(hisTrans);

		ArrayList<Account> lista = new ArrayList<Account>();
		lista.add(acc);

		// CLIENTE
		Client client = new Client();
		client.setBirthdate(new Date());
		client.setCity("Beccar");
		client.setDni("111111");
		client.setEmail("carlos@gmail.com");
		client.setFirstName("Carlos");
		client.setLastName("Rodriguez");
		client.setNationality("Argentina");
		client.setProvince("Buenos Aires");
		client.setSex(true);
		client.setState((byte) 1);
		client.setBankAccounts(lista);
		client.setUser(user);

		session.save(client);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
