package com.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.Account;
import com.Model.Administrative;
import com.Model.Client;
import com.Model.Connection;
import com.Model.FeePayment;
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
		
		User admin = new User();
		user.setUserName("Juanchiturro");
		user.setPassword("123456");
		user.setState((byte) 1);
		user.setUserType("Admin");

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

		//USUARIO BANCO
		Administrative adm = new Administrative();
		adm.setDni("22365986");
		adm.setEmail("Juancho@hotmail.es");
		adm.setFirst_name("Juan");
		adm.setLast_name("Acosta");
		adm.setState(Byte.parseByte("1"));
		adm.setUser(admin);
		
		//CUOTAs
		FeePayment fp = new FeePayment();
		fp.setDate(new Date());
		fp.setLoanId(1);
		
		session.save(client);
		session.save(fp);
		session.save(adm);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
